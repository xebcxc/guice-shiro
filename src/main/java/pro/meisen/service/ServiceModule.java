package pro.meisen.service;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import pro.meisen.service.api.UserService;
import pro.meisen.service.api.adaptor.UserServiceAdaptor;

/**
 * @author meisen
 * 2018-12-19
 */
public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceAdaptor.class).in(Scopes.SINGLETON);
    }
}
