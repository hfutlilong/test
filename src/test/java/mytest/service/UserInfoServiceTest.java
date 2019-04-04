package mytest.service;

import entity.dto.UserInfoDTO;
import mytest.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import service.UserInfoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 用户信息单测
 * @Author lilong
 * @Date 2019-04-03 15:23
 */
public class UserInfoServiceTest extends BaseTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testBatchInsert() {
        List<UserInfoDTO> userInfoPOList = new ArrayList<>();
        userInfoPOList.add(new UserInfoDTO(4, "a1"));
        userInfoPOList.add(new UserInfoDTO(5, "b1"));
        userInfoPOList.add(new UserInfoDTO(6, "c1"));

        userInfoService.batchInsert(userInfoPOList);
    }

    @Test
    public void testInsertSelective() {
        userInfoService.insertSelective(new UserInfoDTO(8, "m"));
        userInfoService.insertSelective(new UserInfoDTO(9, null));
    }

    @Test
    public void testInsertOnDuplicateUpdate() {
        UserInfoDTO UserInfoDTO = new UserInfoDTO(7, "a3");
        userInfoService.insertOnDuplicateUpdate(UserInfoDTO);
    }

    @Test
    public void testBatchUpdate() {
        List<UserInfoDTO> userInfoPOList = new ArrayList<>();
        userInfoPOList.add(new UserInfoDTO(4, "a2"));
        userInfoPOList.add(new UserInfoDTO(5, "b2"));
        userInfoPOList.add(new UserInfoDTO(6, "c2"));
        userInfoService.batchUpdate(userInfoPOList);
    }
}
