package dao.gen.mapper;

import dao.gen.po.TestJsonPO;
import dao.gen.po.TestJsonPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestJsonPOMapper {
    long countByExample(TestJsonPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestJsonPO record);

    int insertSelective(TestJsonPO record);

    List<TestJsonPO> selectByExample(TestJsonPOExample example);

    TestJsonPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestJsonPO record, @Param("example") TestJsonPOExample example);

    int updateByExample(@Param("record") TestJsonPO record, @Param("example") TestJsonPOExample example);

    int updateByPrimaryKeySelective(TestJsonPO record);

    int updateByPrimaryKey(TestJsonPO record);
}