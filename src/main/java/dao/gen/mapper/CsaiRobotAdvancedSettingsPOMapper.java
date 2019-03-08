package dao.gen.mapper;

import dao.gen.po.CsaiRobotAdvancedSettingsPO;
import dao.gen.po.CsaiRobotAdvancedSettingsPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsaiRobotAdvancedSettingsPOMapper {
    long countByExample(CsaiRobotAdvancedSettingsPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CsaiRobotAdvancedSettingsPO record);

    int insertSelective(CsaiRobotAdvancedSettingsPO record);

    List<CsaiRobotAdvancedSettingsPO> selectByExample(CsaiRobotAdvancedSettingsPOExample example);

    CsaiRobotAdvancedSettingsPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CsaiRobotAdvancedSettingsPO record, @Param("example") CsaiRobotAdvancedSettingsPOExample example);

    int updateByExample(@Param("record") CsaiRobotAdvancedSettingsPO record, @Param("example") CsaiRobotAdvancedSettingsPOExample example);

    int updateByPrimaryKeySelective(CsaiRobotAdvancedSettingsPO record);

    int updateByPrimaryKey(CsaiRobotAdvancedSettingsPO record);
}