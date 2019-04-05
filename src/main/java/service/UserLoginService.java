package service;

import entity.vo.UserLoginVO;

public interface UserLoginService {
    /**
     * 注册新用户
     * @param userLoginVO
     */
    void register(UserLoginVO userLoginVO);

    /**
     * 修改账号信息
     * @param userLoginVO
     */
    void updateAccountInfo(UserLoginVO userLoginVO);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    UserLoginVO queryUserById(Long id);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    UserLoginVO queryUserByNamePwd(String username, String password);

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    boolean checkIfUsernameExists(String username);
}
