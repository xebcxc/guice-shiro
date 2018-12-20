package pro.meisen.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.meisen.db.entity.User;
import pro.meisen.service.api.UserRepository;

import javax.inject.Inject;

/**
 * 权限认证器
 * @author meisen
 * 2018-12-20
 */
public class AuthRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthRealm.class);

    private UserRepository userRepository;

    @Inject
    public AuthRealm(CredentialsMatcher matcher, UserRepository userRepository) {
        this.userRepository = userRepository;
        // 设置加密
        setCredentialsMatcher(matcher);
        // 开启内存缓存
        setCacheManager(new MemoryConstrainedCacheManager());
        setAuthenticationTokenClass(UsernamePasswordToken.class);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        // 暂时做任何权限处理

        return authorizationInfo;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userRepository.findByUsername(token.getUsername());
        if (user == null) {
            LOGGER.error("没有找到该用户");
            throw new UnknownAccountException("用户不存在");
        }
        return new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );
    }
}
