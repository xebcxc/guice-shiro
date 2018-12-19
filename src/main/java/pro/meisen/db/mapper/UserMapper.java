package pro.meisen.db.mapper;

import pro.meisen.db.entity.User;

import java.util.List;

/**
 * @author meisen
 * 2018-12-19
 */
public interface UserMapper {

    /**
     * 查询所有
     * @return List<User>
     */
    List<User> queryAll();
}
