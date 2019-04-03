package service.impl;

import dao.gen.mapper.UserInfoPOMapperExt;
import dao.gen.po.UserInfoPO;
import entity.dto.UserInfoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserInfoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 用户信息
 * @Author lilong
 * @Date 2019-04-03 15:19
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoPOMapperExt userInfoPOMapper;

    @Override
    public int insert(UserInfoDTO userInfoDTO) {
        return 0;
    }

    @Override
    public int insertOnDuplicateUpdate(UserInfoDTO userInfoDTO) {
        return 0;
    }

    @Override
    public int batchInsert(List<UserInfoDTO> userInfoDTOList) {
        List<UserInfoPO> userInfoPOList = this.convertUserInfoDTO2PO(userInfoDTOList);
        return userInfoPOMapper.batchInsert(userInfoPOList);
    }

    @Override
    public int batchUpdate(List<UserInfoDTO> userInfoDTOList) {
        List<UserInfoPO> userInfoPOList = this.convertUserInfoDTO2PO(userInfoDTOList);
        return userInfoPOMapper.batchUpdate(userInfoPOList);
    }

    private List<UserInfoPO> convertUserInfoDTO2PO(List<UserInfoDTO> userInfoDTOList) {
        List<UserInfoPO> userInfoPOList = new ArrayList<>();

        userInfoDTOList.forEach(userInfoDTO -> {
            UserInfoPO userInfoPO = new UserInfoPO();
            BeanUtils.copyProperties(userInfoDTO, userInfoPO);
            userInfoPOList.add(userInfoPO);
        });

        return userInfoPOList;
    }
}
