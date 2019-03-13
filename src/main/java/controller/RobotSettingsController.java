package controller;

import com.netease.haitao.core.fastjson.FastJsonUtil;
import common.NodeCommonResponse;
import common.constants.LogConstant;
import common.exception.BizException;
import entity.robot.AdvancedRobotSettingsDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.robot.RobotSettingsService;

/**
 * @Description 机器人设置测试
 * @Author lilong
 * @Date 2019-03-08 15:00
 */
@Controller
@RequestMapping("robot")
public class RobotSettingsController {
    @Autowired
    private RobotSettingsService robotSettingsService;

    @RequestMapping(value = "getAdvancedRobotSettings", method = RequestMethod.GET)
    @ResponseBody
    public NodeCommonResponse getAdvancedRobotSettings(Long corpId, String email) {
        try {
            AdvancedRobotSettingsDTO advancedRobotSettingsDTO = robotSettingsService.getAdvancedRobotSettings(corpId, email);
            return NodeCommonResponse.succ(advancedRobotSettingsDTO);
        } catch (BizException e) {
            LogConstant.BUS.error("getAdvancedRobotSettings failed, exception info: {}.", e);
            return NodeCommonResponse.fail();
        }
    }

    @RequestMapping(value = "setAdvancedRobotSettings")
    @ResponseBody
    public NodeCommonResponse setAdvancedRobotSettings(Long corpId, String email, String advancedRobotSettings) {
        // 参数校验
        if (StringUtils.isBlank(advancedRobotSettings)) {
            LogConstant.BUS.error("setAdvancedRobotSettings failed, because advancedRobotSettingsDTO is null.");
            return NodeCommonResponse.parameterError();
        }
        String newAdvancedRobotSettings;
        try {
            newAdvancedRobotSettings = new String(advancedRobotSettings.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            LogConstant.BUS.error("setAdvancedRobotSettings failed:", e);
            return NodeCommonResponse.parameterError();
        }

        AdvancedRobotSettingsDTO advancedRobotSettingsDTO = FastJsonUtil.parse(newAdvancedRobotSettings, AdvancedRobotSettingsDTO.class);

        int updateRows = robotSettingsService.setAdvancedRobotSettings(corpId, email, advancedRobotSettingsDTO);
        if (updateRows == 1) {
            return NodeCommonResponse.succ();
        } else { // 更新配置失败了
            return NodeCommonResponse.fail();
        }
    }
}
