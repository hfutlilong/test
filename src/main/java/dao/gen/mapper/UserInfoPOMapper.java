package dao.gen.mapper;

import dao.gen.po.UserInfoPO;
import dao.gen.po.UserInfoPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoPOMapper {
    long countByExample(UserInfoPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInfoPO record);

    int insertSelective(UserInfoPO record);

    List<UserInfoPO> selectByExample(UserInfoPOExample example);

    UserInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfoPO record, @Param("example") UserInfoPOExample example);

    int updateByExample(@Param("record") UserInfoPO record, @Param("example") UserInfoPOExample example);

    int updateByPrimaryKeySelective(UserInfoPO record);

    int updateByPrimaryKey(UserInfoPO record);
}