package service.impl;

import common.annotation.RunInTransactional;
import common.constants.LogConstant;
import common.exception.BizException;
import common.exception.ErrorCode;
import dao.gen.mapper.CsaiRobotAdvancedSettingsPOMapperExt;
import dao.gen.po.CsaiRobotAdvancedSettingsPO;
import entity.AdvancedRobotSettingsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RobotSettingsService;
import utils.DateUtil;

import java.sql.Timestamp;

/**
 * @Description 客服机器人设置
 * @Author lilong
 * @Date 2019-02-18 16:48
 */
@Service
public class RobotSettingsServiceImpl implements RobotSettingsService {
    @Autowired
    private CsaiRobotAdvancedSettingsPOMapperExt csaiRobotAdvancedSettingsPOMapper;

    private static final int SWITCH_ON = 1;

    @Override
    @RunInTransactional
    public AdvancedRobotSettingsDTO getAdvancedRobotSettings(Long corpId, String email) {
        AdvancedRobotSettingsDTO advancedRobotSettingsDTO = new AdvancedRobotSettingsDTO();
        CsaiRobotAdvancedSettingsPO csaiRobotAdvancedSettingsPO = csaiRobotAdvancedSettingsPOMapper
                .queryAdvancedRobotSettings(corpId);
        if (csaiRobotAdvancedSettingsPO != null && csaiRobotAdvancedSettingsPO.getAdvancedSettings() != null) {
            BeanUtils.copyProperties(csaiRobotAdvancedSettingsPO.getAdvancedSettings(), advancedRobotSettingsDTO);
        } else { // 没查到，则往数据库里插入一条默认值，并返回默认值
            advancedRobotSettingsDTO = getDefaultAdvancedSettings();
            Timestamp currentTimestamp = DateUtil.getCurrentTimestamp();

            csaiRobotAdvancedSettingsPO = new CsaiRobotAdvancedSettingsPO();
            csaiRobotAdvancedSettingsPO.setCorpId(corpId);
            csaiRobotAdvancedSettingsPO.setAdvancedSettings(advancedRobotSettingsDTO);
            csaiRobotAdvancedSettingsPO.setCreator(email);
            csaiRobotAdvancedSettingsPO.setUpdator(email);
            csaiRobotAdvancedSettingsPO.setCreateTime(currentTimestamp);
            csaiRobotAdvancedSettingsPO.setUpdateTime(currentTimestamp);
            int rows = csaiRobotAdvancedSettingsPOMapper.insertAdvancedRobotSettings(csaiRobotAdvancedSettingsPO);
            if (rows != 1) {
                throw new BizException(ErrorCode.DATA_INSERT_FAILED,
                        "getAdvancedRobotSettings insert failed, corpId: " + corpId);
            }
            LogConstant.BUS.info("getAdvancedRobotSettings insert success, corpId:{}.", corpId);
        }
        return advancedRobotSettingsDTO;
    }

    @Override
    @RunInTransactional
    public int setAdvancedRobotSettings(Long corpId, String email, AdvancedRobotSettingsDTO advancedRobotSettingsDTO) {
        CsaiRobotAdvancedSettingsPO csaiRobotAdvancedSettingsPO = csaiRobotAdvancedSettingsPOMapper
                .queryAdvancedRobotSettings(corpId);
        if (csaiRobotAdvancedSettingsPO == null) {
            LogConstant.BUS.error("setAdvancedRobotSettings failed, advanced settings does not exist, corpId: {}.",
                    corpId);
            return -1;
        }

        csaiRobotAdvancedSettingsPO.setCorpId(corpId);
        csaiRobotAdvancedSettingsPO.setUpdator(email);
        csaiRobotAdvancedSettingsPO.setUpdateTime(DateUtil.getCurrentTimestamp());

        // TODO 应该测试下是否改了不需要的覆盖的字段
        BeanUtils.copyProperties(advancedRobotSettingsDTO, csaiRobotAdvancedSettingsPO.getAdvancedSettings());

        return csaiRobotAdvancedSettingsPOMapper.updateAdvancedRobotSettings(csaiRobotAdvancedSettingsPO);
    }

    /**
     * 获取高级设置的默认值
     *
     * @return
     */
    private AdvancedRobotSettingsDTO getDefaultAdvancedSettings() {
        String defaultAnswerEvaluationTips = "点击反馈不满意原因，小考拉会持续改进哦~";

        AdvancedRobotSettingsDTO advancedRobotSettingsDTO = new AdvancedRobotSettingsDTO();
        advancedRobotSettingsDTO.setRobotAnswerEvaluation(SWITCH_ON);
        advancedRobotSettingsDTO.setAskBadCommentReason(SWITCH_ON);
        advancedRobotSettingsDTO.setRobotAnswerEvaluationSettings(defaultAnswerEvaluationTips);
        advancedRobotSettingsDTO.setRobotDialogueInputAssociation(SWITCH_ON);
        advancedRobotSettingsDTO.setUseDefaultRobotAsBottomPlan(SWITCH_ON);
        return advancedRobotSettingsDTO;
    }
}

