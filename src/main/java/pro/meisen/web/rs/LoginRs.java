package pro.meisen.web.rs;

/**
 * 登录出参
 * @author meisen
 * 2018-12-20
 */
public class LoginRs {

    // 用户id
    private String id;
    // 用户名
    private String username;

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
}
