package pro.meisen.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pro.meisen.boot.AppModule;
import pro.meisen.db.entity.User;
import pro.meisen.service.api.UserService;

import java.util.List;

public class AppTest {

    private static Injector injector;

    @BeforeClass
    public static void init() {
        injector = Guice.createInjector(new AppModule());
    }

    @Test
    public void testQueryUser() {
        UserService userService = injector.getInstance(UserService.class);
        List<User> users = userService.queryAllUser();
        System.out.println(users);
    }


}
