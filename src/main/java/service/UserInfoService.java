package service;

import entity.dto.UserInfoDTO;

import java.util.List;

public interface UserInfoService {
    void batchInsert(List<UserInfoDTO> userInfoPOList);
}
