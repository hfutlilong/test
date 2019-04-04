package service.impl;

import dao.gen.mapper.UserInfoPOMapperExt;
import dao.gen.po.UserInfoPO;
import entity.dto.UserInfoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public int insertSelective(UserInfoDTO userInfoDTO) {
        return userInfoPOMapper.insertSelective(convertUserInfo2PO(userInfoDTO));
    }

    @Override
    public int insertOnDuplicateUpdate(UserInfoDTO userInfoDTO) {
        return userInfoPOMapper.insertOnDuplicateUpdate(convertUserInfo2PO(userInfoDTO));
    }

    @Override
    @Transactional
    public int batchInsert(List<UserInfoDTO> userInfoDTOList) {
        List<UserInfoPO> userInfoPOList = this.convertUserInfoList2PO(userInfoDTOList);
        return userInfoPOMapper.batchInsert(userInfoPOList);
    }

    @Override
    @Transactional
    public int batchUpdate(List<UserInfoDTO> userInfoDTOList) {
        List<UserInfoPO> userInfoPOList = this.convertUserInfoList2PO(userInfoDTOList);
        return userInfoPOMapper.batchUpdate(userInfoPOList);
    }

    private List<UserInfoPO> convertUserInfoList2PO(List<UserInfoDTO> userInfoDTOList) {
        List<UserInfoPO> userInfoPOList = new ArrayList<>();

        userInfoDTOList.forEach(userInfoDTO -> {
            userInfoPOList.add(convertUserInfo2PO(userInfoDTO));
        });

        return userInfoPOList;
    }

    private UserInfoPO convertUserInfo2PO(UserInfoDTO userInfoDTO) {
        UserInfoPO userInfoPO = new UserInfoPO();
        BeanUtils.copyProperties(userInfoDTO, userInfoPO);
        return userInfoPO;
    }
}
