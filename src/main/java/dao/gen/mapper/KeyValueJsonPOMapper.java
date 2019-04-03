package dao.gen.mapper;

import dao.gen.po.KeyValueJsonPO;
import dao.gen.po.KeyValueJsonPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeyValueJsonPOMapper {
    long countByExample(KeyValueJsonPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(KeyValueJsonPO record);

    int insertSelective(KeyValueJsonPO record);

    List<KeyValueJsonPO> selectByExample(KeyValueJsonPOExample example);

    KeyValueJsonPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") KeyValueJsonPO record, @Param("example") KeyValueJsonPOExample example);

    int updateByExample(@Param("record") KeyValueJsonPO record, @Param("example") KeyValueJsonPOExample example);

    int updateByPrimaryKeySelective(KeyValueJsonPO record);

    int updateByPrimaryKey(KeyValueJsonPO record);
}