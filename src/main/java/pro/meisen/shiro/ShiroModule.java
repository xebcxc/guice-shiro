package pro.meisen.shiro;

import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import org.apache.shiro.guice.web.GuiceShiroFilter;

/**
 * shiro模块
 * @author meisen
 * 2018-12-20
 */
public class ShiroModule extends ServletModule {

    @Override
    protected void configureServlets() {
        super.configureServlets();
        // 绑定Shiro SecurityManager模块
        install(new ShiroSecurityModule(getServletContext()));
        // 绑定拦截器
        bind(ShiroRequestFilter.class).in(Scopes.SINGLETON);
        // 所有请求都会通过ShiroRequestFilter
        filter("/*").through(ShiroRequestFilter.class);
        // 所有请求都会通过GuiceShiroFilter
        filter("/*").through(GuiceShiroFilter.class);
    }
}
