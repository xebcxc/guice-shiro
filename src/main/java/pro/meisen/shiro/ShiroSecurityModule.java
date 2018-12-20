package pro.meisen.shiro;

import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.guice.web.ShiroWebModule;

import javax.servlet.ServletContext;

/**
 * Shiro SecurityManager模块
 * 1.添加拦截器链 filterChains
 * 2.绑定注解url
 * 3.绑定Realm
 * 4.绑定加密算法
 * @author meisen
 * 2018-12-20
 */
public class ShiroSecurityModule extends ShiroWebModule {
    // 算法名
    private static final String HASH_ALGORITHM = "MD5";
    // 散列次数
    private static final int HASH_ITERATIONS = 1024;

    // 登录注解
    private static final Named NAMED_LOGINURL = Names.named("shiro.loginUrl");

    // 未授权
    private static final String REST_API_UNAUTHORIZED = "/user/unauthorized";


    public ShiroSecurityModule(ServletContext servletContext) {
        super(servletContext);
    }

    @Override
    protected void configureShiroWeb() {
        // 绑定注解常量
        bindConstants();
        // 绑定算法
        bindCredentialsMatcher();
        // 绑定realm
        bindRealm().to(AuthRealm.class);

        // add Filter
        addFilterChain("/user/login", ANON);
        addFilterChain("/user/logout", LOGOUT);
        addFilterChain("/**", AUTHC);
    }


    private void bindConstants() {
        bindConstant().annotatedWith(NAMED_LOGINURL).to(REST_API_UNAUTHORIZED);
    }

    /**
     * 绑定凭证匹配器
     */
    private void bindCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 设置散列算法
        hashedCredentialsMatcher.setHashAlgorithmName(HASH_ALGORITHM);
        // 设置散列次数
        hashedCredentialsMatcher.setHashIterations(HASH_ITERATIONS);
        bind(CredentialsMatcher.class).toInstance(hashedCredentialsMatcher);
    }
}
