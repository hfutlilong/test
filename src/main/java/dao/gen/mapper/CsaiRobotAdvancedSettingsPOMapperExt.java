package dao.gen.mapper;

import dao.gen.po.CsaiRobotAdvancedSettingsPO;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-03-08 14:52
 */
public interface CsaiRobotAdvancedSettingsPOMapperExt extends CsaiRobotAdvancedSettingsPOMapper {
    /**
     * 查询机器人高级配置
     * @param corpId
     * @return
     */
    CsaiRobotAdvancedSettingsPO queryAdvancedRobotSettings(Long corpId);

    /**
     * 更新机器人高级配置
     * @param csaiRobotAdvancedSettingsPO
     * @return
     */
    int updateAdvancedRobotSettings(CsaiRobotAdvancedSettingsPO csaiRobotAdvancedSettingsPO);

    /**
     * 插入机器人高级设置
     *
     * @param csaiRobotAdvancedSettingsPO
     * @return
     */
    int insertAdvancedRobotSettings(CsaiRobotAdvancedSettingsPO csaiRobotAdvancedSettingsPO);

    /**
     * 获取当前事务id
     * @return
     */
    String getCurrentTransactionId();
}
