package pro.meisen.boot;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Guice加载初始化
 * @author meisen
 * 2018-12-19
 */
public class BootstrapListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new AppModule());
    }
}
