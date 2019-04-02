package dao.gen.mapper;

import dao.gen.po.UserInfoPO;

import java.util.List;

public interface UserInfoPOMapperExt extends UserInfoPOMapper {
    int batchInsert(List<UserInfoPO> userInfoPOList);
}
