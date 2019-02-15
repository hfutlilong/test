package dao.gen.mapper;

import dao.gen.po.KeyValuePO;
import dao.gen.po.KeyValuePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeyValuePOMapper {
    long countByExample(KeyValuePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(KeyValuePO record);

    int insertSelective(KeyValuePO record);

    List<KeyValuePO> selectByExample(KeyValuePOExample example);

    KeyValuePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") KeyValuePO record, @Param("example") KeyValuePOExample example);

    int updateByExample(@Param("record") KeyValuePO record, @Param("example") KeyValuePOExample example);

    int updateByPrimaryKeySelective(KeyValuePO record);

    int updateByPrimaryKey(KeyValuePO record);
}