package pro.meisen.boot;

import com.google.inject.AbstractModule;
import pro.meisen.db.DataModule;
import pro.meisen.service.ServiceModule;
import pro.meisen.shiro.ShiroModule;

/**
 * 程序Module
 * 用于绑定功能模块
 * @author meisen
 * 2018-12-19
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        // 绑定mybatis数据模块
        install(new DataModule());
        // 绑定service服务模块
        install(new ServiceModule());
        // 绑定shiro模块
        install(new ShiroModule());
    }
}
