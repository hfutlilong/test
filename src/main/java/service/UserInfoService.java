package service;

import entity.dto.UserInfoDTO;

import java.util.List;

public interface UserInfoService {
    /**
     * 插入一条记录
     * @param userInfoDTO
     * @return
     */
    int insertSelective(UserInfoDTO userInfoDTO);

    /**
     * 插入一条记录，如果唯一键冲突则更新
     * @param userInfoDTO
     * @return
     */
    int insertOnDuplicateUpdate(UserInfoDTO userInfoDTO);

    /**
     * 批量插入
     * @param userInfoPOList
     */
    int batchInsert(List<UserInfoDTO> userInfoPOList);

    /**
     * 批量更新
     * @param userInfoPOList
     */
    int batchUpdate(List<UserInfoDTO> userInfoPOList);
}
