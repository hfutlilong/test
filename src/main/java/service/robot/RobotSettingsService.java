package service.robot;

import entity.robot.AdvancedRobotSettingsDTO;
import entity.robot.RobotSettingsDetailDTO;
import entity.robot.RobotSummaryInfoDTO;

import java.util.List;

public interface RobotSettingsService {
    /**
     * 查询机器人高级设置 如果没查到，则往数据库中插入默认设置，并将该默认值返回给前端
     *
     * @param corpId
     * @param email
     * @return
     */
    AdvancedRobotSettingsDTO getAdvancedRobotSettings(Long corpId, String email);

    /**
     * 更新机器人设置
     *
     * @param corpId
     * @param email
     * @param advancedRobotSettingsDTO
     * @return
     */
    int setAdvancedRobotSettings(Long corpId, String email, AdvancedRobotSettingsDTO advancedRobotSettingsDTO);

    /**
     * 查询机器人列表 1.按创建机器人的时间排序 2.默认机器人要排在第一位
     *
     * @param corpId
     * @return
     */
    List<RobotSummaryInfoDTO> getRobotList(Long corpId);

    /**
     * 获取机器人配置信息
     *
     * @param robotId
     * @return
     */
    RobotSettingsDetailDTO getRobotSettings(String robotId);

    /**
     * 新建或更新机器人配置
     * 1.传入robotId-更新，不传-新建
     * 2.机器人对内名称去重
     * @param corpId
     * @param robotId
     * @param robotSettingsDetailDTO
     * @return
     */
    void updateRobotSettings(Long corpId, String robotId, RobotSettingsDetailDTO robotSettingsDetailDTO);
}
