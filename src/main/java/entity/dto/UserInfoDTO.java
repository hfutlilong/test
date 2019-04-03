package entity.dto;

import java.io.Serializable;

/**
 * @Description userInfo
 * @Author lilong
 * @Date 2019-04-03 15:18
 */
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = -5548291137924820519L;

    private Integer userId;

    private String userName;

    public UserInfoDTO() {

    }

    public UserInfoDTO(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
