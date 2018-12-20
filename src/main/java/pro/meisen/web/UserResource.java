package pro.meisen.web;

import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.meisen.db.entity.User;
import pro.meisen.web.rq.LoginRq;
import pro.meisen.web.rs.LoginRs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 用户接口
 * @author meisen
 * 2018-12-19
 */
@Path("/user")
public class UserResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    /**
     * 用户登录
     * @param rq 登录入参
     * @return 登录出参
     */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginRs login(LoginRq rq) {
        if (null == rq || Strings.isNullOrEmpty(rq.getUsername()) || Strings.isNullOrEmpty(rq.getPassword())) {
            LOGGER.error("用户登录入参错误! rq: {}", rq);
            throw new UnauthorizedException("用户登录入参错误");
        }
        String username = rq.getUsername();
        String password = rq.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        LoginRs rs = new LoginRs();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            rs.setId(user.getId());
            rs.setUsername(user.getUsername());
        } catch (AuthenticationException e) {
            LOGGER.error("登录出错");
        }
        return rs;
    }

    /**
     * 用户未授权
     * @return message
     */
    @GET
    @Path("/unauthorized")
    @Produces(MediaType.APPLICATION_JSON)
    public String unauthorized() {
        return "用户未登录";
    }

    /**
     * 用户登出
     * @return message
     */
    @GET
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "用户登出";
    }
}
