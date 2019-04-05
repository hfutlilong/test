package dao.gen.mapper;

import dao.gen.po.UserLoginPO;
import dao.gen.po.UserLoginPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginPOMapper {
    long countByExample(UserLoginPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLoginPO record);

    int insertSelective(UserLoginPO record);

    List<UserLoginPO> selectByExample(UserLoginPOExample example);

    UserLoginPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLoginPO record, @Param("example") UserLoginPOExample example);

    int updateByExample(@Param("record") UserLoginPO record, @Param("example") UserLoginPOExample example);

    int updateByPrimaryKeySelective(UserLoginPO record);

    int updateByPrimaryKey(UserLoginPO record);
}