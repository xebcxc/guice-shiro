package pro.meisen.web;

import pro.meisen.db.entity.User;
import pro.meisen.service.api.UserService;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 用户接口
 * @author meisen
 * 2018-12-19
 */
@Path("/user")
public class UserResource {

    private UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> all() {
        return userService.queryAllUser();
    }
}
