package pro.meisen.service.api;

import pro.meisen.db.entity.User;

import java.util.List;

/**
 * 用户服务
 * @author meisen
 * 2018-12-19
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return 所有用户
     */
    List<User> queryAllUser();
}
