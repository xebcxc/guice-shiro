package pro.meisen.db;

import com.google.inject.name.Names;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.dbcp.BasicDataSourceProvider;
import pro.meisen.boot.PropertiesModule;
import pro.meisen.db.mapper.UserMapper;

/**
 * 数据库模块
 * 需要绑定连接常量
 * @author meisen
 * 2018-12-19
 */
public class DataModule extends MyBatisModule {
    // 数据库连接常量
    private static final String DATABASE_PROPERTIES = "data.properties";

    @Override
    protected void initialize() {
        bindDataSourceProviderType(BasicDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        // 绑定连接数据库常量
        // bindDatabaseConstants();
        // 也可以通过读取配置文件绑定链接数据常量
        install(new PropertiesModule(DATABASE_PROPERTIES));
        // 绑定数据库mapper
        addMapperClasses();
    }

    /**
     * 绑定数据库连接常量
     */
    private void bindDatabaseConstants() {
        // 这里可以用来绑定数据库
        bindConstant().annotatedWith(Names.named("JDBC.driver")).to("com.mysql.jdbc.Driver");
        bindConstant().annotatedWith(Names.named("JDBC.url")).to("jdbc:mysql://localhost:3306/dev");
        bindConstant().annotatedWith(Names.named("JDBC.username")).to("root");
        bindConstant().annotatedWith(Names.named("JDBC.password")).to("123456");
        bindConstant().annotatedWith(Names.named("mybatis.environment.id")).to("dev");
    }


    /**
     * 绑定数据库mapper
     */
    private void addMapperClasses() {
        // 用户
        addMapperClass(UserMapper.class);
    }
}
