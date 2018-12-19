package pro.meisen.service.api.adaptor;

import pro.meisen.db.entity.User;
import pro.meisen.db.mapper.UserMapper;
import pro.meisen.service.api.UserService;

import javax.inject.Inject;
import java.util.List;

/**
 * @author meisen
 * 2018-12-19
 */
public class UserServiceAdaptor implements UserService {
    private UserMapper userMapper;

    @Inject
    public UserServiceAdaptor(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAll();
    }
}
