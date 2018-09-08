package dao.gen.mapper;

import dao.gen.po.User1;
import dao.gen.po.User1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User1Mapper {
    int countByExample(User1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(User1 record);

    int insertSelective(User1 record);

    List<User1> selectByExample(User1Example example);

    User1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User1 record, @Param("example") User1Example example);

    int updateByExample(@Param("record") User1 record, @Param("example") User1Example example);

    int updateByPrimaryKeySelective(User1 record);

    int updateByPrimaryKey(User1 record);
}