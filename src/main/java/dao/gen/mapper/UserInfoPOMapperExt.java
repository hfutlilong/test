package dao.gen.mapper;

import dao.gen.po.UserInfoPO;

import java.util.List;

public interface UserInfoPOMapperExt extends UserInfoPOMapper {
    /**
     * 插入一条记录
     * 
     * @param userInfoPO
     * @return
     */
    int insertSelective(UserInfoPO userInfoPO);

    /**
     * 插入一条记录，如果唯一键冲突则更新
     * 
     * @param userInfoPO
     * @return
     */
    int insertOnDuplicateUpdate(UserInfoPO userInfoPO);

    /**
     * 更新一条记录
     * 
     * @param userInfoPO
     * @return
     */
    int updateSelective(UserInfoPO userInfoPO);

    /**
     * 批量插入
     * 
     * @param userInfoPOList
     * @return
     */
    int batchInsert(List<UserInfoPO> userInfoPOList);

    /**
     * 批量更新
     * 
     * @param userInfoPOList
     * @return
     */
    int batchUpdate(List<UserInfoPO> userInfoPOList);
}
