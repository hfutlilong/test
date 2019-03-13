package dao.gen.mapper;

import dao.gen.po.CsaiRobotSettingsPO;
import entity.robot.RobotSettingsDetailDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CsaiRobotSettingsPOMapperExt extends CsaiRobotSettingsPOMapper {
    /**
     * 查询机器人列表
     * @return
     */
    List<CsaiRobotSettingsPO> queryRobotList(Long corpId);

    /**
     * 查询机器人设置
     * @param robotId
     * @return
     */
    CsaiRobotSettingsPO queryRobotSettings(String robotId);

    /**
     * 获取企业的默认机器人id
     * @param corpId
     * @return
     */
    String getDefaultRobotId(Long corpId);

    /**
     * 查询机器人对内名称的重复次数
     * @param corpId
     * @param internalName
     * @return
     */
    int countInternalName(@Param("corpId")Long corpId, @Param("internalName") String internalName);

    /**
     * 选择性插入
     * @param robotId
     * @param robotSettingsDetailDTO
     * @return
     */
    int insertSelective(@Param("robotId")String robotId, @Param("robotSettingsDetailDTO") RobotSettingsDetailDTO robotSettingsDetailDTO);

    /**
     * 选择性更新
     * @param robotId
     * @param robotSettingsDetailDTO
     * @return
     */
    int updateSelective(@Param("robotId")String robotId, @Param("robotSettingsDetailDTO") RobotSettingsDetailDTO robotSettingsDetailDTO);
}
