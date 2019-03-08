package service;

import entity.AdvancedRobotSettingsDTO;

public interface RobotSettingsService {
    /**
     * 查询机器人高级设置
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
}
