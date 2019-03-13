package dao.gen.mapper;

import dao.gen.po.CsaiRobotEntrancePO;
import dao.gen.po.CsaiRobotEntrancePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsaiRobotEntrancePOMapper {
    long countByExample(CsaiRobotEntrancePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CsaiRobotEntrancePO record);

    int insertSelective(CsaiRobotEntrancePO record);

    List<CsaiRobotEntrancePO> selectByExample(CsaiRobotEntrancePOExample example);

    CsaiRobotEntrancePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CsaiRobotEntrancePO record, @Param("example") CsaiRobotEntrancePOExample example);

    int updateByExample(@Param("record") CsaiRobotEntrancePO record, @Param("example") CsaiRobotEntrancePOExample example);

    int updateByPrimaryKeySelective(CsaiRobotEntrancePO record);

    int updateByPrimaryKey(CsaiRobotEntrancePO record);
}