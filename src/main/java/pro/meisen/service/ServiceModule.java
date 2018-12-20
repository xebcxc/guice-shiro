package pro.meisen.service;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import pro.meisen.service.api.UserRepository;
import pro.meisen.service.api.adaptor.UserAdaptor;

/**
 * @author meisen
 * 2018-12-19
 */
public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserRepository.class).to(UserAdaptor.class).in(Scopes.SINGLETON);
    }
}
