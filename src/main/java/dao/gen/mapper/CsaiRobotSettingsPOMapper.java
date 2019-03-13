package dao.gen.mapper;

import dao.gen.po.CsaiRobotSettingsPO;
import dao.gen.po.CsaiRobotSettingsPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsaiRobotSettingsPOMapper {
    long countByExample(CsaiRobotSettingsPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CsaiRobotSettingsPO record);

    int insertSelective(CsaiRobotSettingsPO record);

    List<CsaiRobotSettingsPO> selectByExample(CsaiRobotSettingsPOExample example);

    CsaiRobotSettingsPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CsaiRobotSettingsPO record, @Param("example") CsaiRobotSettingsPOExample example);

    int updateByExample(@Param("record") CsaiRobotSettingsPO record, @Param("example") CsaiRobotSettingsPOExample example);

    int updateByPrimaryKeySelective(CsaiRobotSettingsPO record);

    int updateByPrimaryKey(CsaiRobotSettingsPO record);
}