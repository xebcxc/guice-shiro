package pro.meisen.db.entity;

import java.util.UUID;

/**
 * @author meisen
 * 2018-12-19
 */
public class User {
    // 用户id
    private String id = UUID.randomUUID().toString().replaceAll("-", "");;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 插入日志
    private String date;

    // 盐
    private String salt = "r[noT";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }

}
