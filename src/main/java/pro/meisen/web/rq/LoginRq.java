package pro.meisen.web.rq;

/**
 * 用户登录入参
 * @author meisen
 * 2018-12-20
 */
public class LoginRq {

    // 用户名
    private String username;
    // 用户密码
    private String password;

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
}
