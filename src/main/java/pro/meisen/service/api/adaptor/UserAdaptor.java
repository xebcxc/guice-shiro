package pro.meisen.service.api.adaptor;

import com.google.common.base.Strings;
import pro.meisen.db.entity.User;
import pro.meisen.db.mapper.UserMapper;
import pro.meisen.service.api.UserRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * @author meisen
 * 2018-12-19
 */
public class UserAdaptor implements UserRepository {
    private UserMapper userMapper;

    @Inject
    public UserAdaptor(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAll();
    }

    @Override
    public User findByUsername(String username) {
        if (Strings.isNullOrEmpty(username)) {
            return new User();
        }
        return userMapper.findByUsername(username);
    }
}
