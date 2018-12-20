package pro.meisen.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.inject.Guice;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;
import pro.meisen.web.UserResource;

import javax.inject.Inject;

/**
 * @author meisen
 * 2018-12-19
 */
public class JerseyResources extends ResourceConfig {
    /**
     * 注册
     * @param serviceLocator registry for HK2 services
     */
    @Inject
    public JerseyResources(ServiceLocator serviceLocator) {
        registerInjector(serviceLocator);
        registerProvider();
        register(UserResource.class);
    }

    /**
     * 和Guice整合
     * @param serviceLocator registry for HK2 services
     */
    private void registerInjector(ServiceLocator serviceLocator) {
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(Guice.createInjector(new AppModule()));
    }

    /**
     * 将response转换为json
     */
    private void registerProvider() {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        ObjectMapper mapper = new ObjectMapper();
        provider.setMapper(mapper);
        register(provider);
    }

}
