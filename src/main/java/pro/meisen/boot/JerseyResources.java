package pro.meisen.boot;

import org.glassfish.jersey.server.ResourceConfig;
import pro.meisen.web.UserResource;

/**
 * @author meisen
 * 2018-12-19
 */
public class JerseyResources extends ResourceConfig {
    /**
     * 注册
     */
    public JerseyResources() {
        register(UserResource.class);
    }
}
