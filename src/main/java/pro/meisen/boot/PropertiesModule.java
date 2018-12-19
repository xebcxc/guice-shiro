package pro.meisen.boot;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件模块
 * 用于读取配置文件
 * @author meisen
 * 2018-12-19
 */
public class PropertiesModule extends AbstractModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesModule.class);

    private String file;

    public PropertiesModule(String file) {
        this.file = file;
    }

    @Override
    protected void configure() {
        // 获取配置文件
        Properties properties = loadProperties();
        // 绑定配置
        Names.bindProperties(binder(), properties);
        // 这里其实可以打印配置,便于排查
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            // 读取resource中的配置文件
            inputStream = PropertiesModule.class.getClassLoader().getResourceAsStream(file);
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("读取配置文件错误");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.error("关闭数据流出错");
                }
            }
        }
        return properties;
    }
}
