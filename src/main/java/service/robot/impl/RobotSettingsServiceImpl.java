package service.robot.impl;

import common.annotation.RunInTransactional;
import common.constants.LogConstant;
import common.exception.BizException;
import common.exception.ErrorCode;
import dao.gen.mapper.CsaiRobotAdvancedSettingsPOMapperExt;
import dao.gen.mapper.CsaiRobotEntrancePOMapperExt;
import dao.gen.mapper.CsaiRobotSettingsPOMapperExt;
import dao.gen.po.CsaiRobotAdvancedSettingsPO;
import dao.gen.po.CsaiRobotEntrancePO;
import dao.gen.po.CsaiRobotSettingsPO;
import entity.robot.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.robot.RobotSettingsService;
import utils.DateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class RobotSettingsServiceImpl implements RobotSettingsService {
    @Autowired
    private CsaiRobotSettingsPOMapperExt csaiRobotSettingsPOMapper;

    @Autowired
    private CsaiRobotAdvancedSettingsPOMapperExt csaiRobotAdvancedSettingsPOMapper;

    @Autowired
    private CsaiRobotEntrancePOMapperExt csaiRobotEntrancePOMapper;

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

        // 拷贝机器人高级设置
        this.copyAdvancedSettingsWithoutNull(advancedRobotSettingsDTO,
                csaiRobotAdvancedSettingsPO.getAdvancedSettings());
        return csaiRobotAdvancedSettingsPOMapper.updateAdvancedRobotSettings(csaiRobotAdvancedSettingsPO);
    }

    /**
     * 查询机器人列表 1.检查各项配置完成情况 2.按创建时间排序，默认机器人排到最前面（SQL层完成排序）
     *
     * @param corpId
     * @return
     */
    @Override
    public List<RobotSummaryInfoDTO> getRobotList(Long corpId) {
        List<RobotSummaryInfoDTO> robotSummaryInfoList = new ArrayList<>();

        List<CsaiRobotSettingsPO> robotList = csaiRobotSettingsPOMapper.queryRobotList(corpId);

        robotList.forEach(robotSettings -> {
            RobotSummaryInfoDTO robotSummaryInfoDTO = new RobotSummaryInfoDTO();
            robotSummaryInfoDTO.setRobotId(robotSettings.getRobotId());
            robotSummaryInfoDTO.setLogoUrl(robotSettings.getLogoUrl());
            robotSummaryInfoDTO.setInternalName(robotSettings.getInternalName());
            robotSummaryInfoDTO.setRobotType(robotSettings.getRobotType().getIntValue());
            robotSummaryInfoDTO.setRobotStatus(robotSettings.getRobotStatus().getIntValue());
            // 检查各项配置完成情况
            robotSummaryInfoDTO.setBaseSettingsDone(this.checkBaseSettingsDone(robotSettings) ? 1 : 0);
            robotSummaryInfoDTO.setAlgirithmModelDone(this.checkAlgirithmModelDone(robotSettings) ? 1 : 0);
            robotSummaryInfoDTO.setKnowledgeCategoryDone(this.checkKnowledgeCategoryDone(robotSettings) ? 1 : 0);
            robotSummaryInfoDTO.setEntranceSourceDone(this.checkEntranceSourceDone(robotSettings) ? 1 : 0);

            robotSummaryInfoList.add(robotSummaryInfoDTO);
        });

        return robotSummaryInfoList;
    }

    @Override
    public RobotSettingsDetailDTO getRobotSettings(String robotId) {
        CsaiRobotSettingsPO csaiRobotSettingsPO = csaiRobotSettingsPOMapper.queryRobotSettings(robotId);
        if (csaiRobotSettingsPO == null) {
            LogConstant.BUS.error("getRobotSettings failed, robotId {} not exists.", robotId);
            throw new BizException("robotId not exists");
        }

        RobotSettingsDetailDTO robotSettingsDetailDTO = new RobotSettingsDetailDTO();
        robotSettingsDetailDTO.setSwitchOnOff(csaiRobotSettingsPO.getRobotStatus().getIntValue());
        robotSettingsDetailDTO.setRobotType(csaiRobotSettingsPO.getRobotType().getIntValue());
        robotSettingsDetailDTO.setRobotBaseSettings(this.getRobotBaseSettings(csaiRobotSettingsPO));
        robotSettingsDetailDTO.setRobotAlgorithmSettings(this.getRobotAlgorithmSettings(csaiRobotSettingsPO));
        robotSettingsDetailDTO.setBindingKnowledgeCategory(this.getBindingKnowledgeCategory(csaiRobotSettingsPO));
        robotSettingsDetailDTO.setRobotEntranceSummary(this.getRobotEntranceSummary(robotId));

        return robotSettingsDetailDTO;
    }

    @Override
    @RunInTransactional
    public void updateRobotSettings(Long corpId, String robotId, RobotSettingsDetailDTO robotSettingsDetailDTO) {
        RobotBaseSettings robotBaseSettings = robotSettingsDetailDTO.getRobotBaseSettings();
        String internalName = null; // 对内名称
        if (robotBaseSettings != null) {
            // 如果配置了基本信息，则必须输入对内名称
            internalName = robotBaseSettings.getInternalName();
            if (StringUtils.isBlank(internalName)) {
                throw new BizException("updateRobotSettings failed, internalName cannot be blank.");
            }
        }

        // TODO 待定
        // 不允许对内名称有重复
//        if (StringUtils.isNotBlank(internalName)) {
//            int internalNameRepeatCount = csaiRobotSettingsPOMapper.countInternalName(corpId, internalName);
//            if (internalNameRepeatCount > 0) {
//                throw new CsaiBizException("updateRobotSettings failed, internalName cannot repeat.");
//            }
//        }

        if (StringUtils.isBlank(robotId)) {
            // 不传robotId表示插入
            int updateRows = csaiRobotSettingsPOMapper.insertSelective(robotId, robotSettingsDetailDTO);
            if (updateRows != 1) {
                throw new BizException("updateRobotSettings failed, insert failed.");
            }
        } else {
            // 传robotId表示更新
            int updateRows = csaiRobotSettingsPOMapper.updateSelective(robotId, robotSettingsDetailDTO);
            if (updateRows != 1) {
                throw new BizException("updateRobotSettings failed, update failed.");
            }
        }
    }

    /**
     * 获取高级设置的默认值
     *
     * @return
     */
    private AdvancedRobotSettingsDTO getDefaultAdvancedSettings() {
        // 默认机器人答案评价提示语
        String defaultAnswerEvaluationTips = "点击反馈不满意原因，小考拉会持续改进哦~";

        AdvancedRobotSettingsDTO advancedRobotSettingsDTO = new AdvancedRobotSettingsDTO();
        advancedRobotSettingsDTO.setRobotAnswerEvaluation(SWITCH_ON);
        advancedRobotSettingsDTO.setAskBadCommentReason(SWITCH_ON);
        advancedRobotSettingsDTO.setRobotAnswerEvaluationSettings(defaultAnswerEvaluationTips);
        advancedRobotSettingsDTO.setRobotDialogueInputAssociation(SWITCH_ON);
        advancedRobotSettingsDTO.setUseDefaultRobotAsBottomPlan(SWITCH_ON);
        return advancedRobotSettingsDTO;
    }

    /**
     * 拷贝机器人高级设置，如果有null值则跳过
     *
     * @param source
     * @param target
     */
    private void copyAdvancedSettingsWithoutNull(AdvancedRobotSettingsDTO source, AdvancedRobotSettingsDTO target) {
        Integer robotAnswerEvaluation = source.getRobotAnswerEvaluation();
        Integer askBadCommentReason = source.getAskBadCommentReason();
        String robotAnswerEvaluationSettings = source.getRobotAnswerEvaluationSettings();
        Integer robotDialogueInputAssociation = source.getRobotDialogueInputAssociation();
        Integer useDefaultRobotAsBottomPlan = source.getUseDefaultRobotAsBottomPlan();

        if (robotAnswerEvaluation != null) {
            target.setRobotAnswerEvaluation(robotAnswerEvaluation);
        }
        if (askBadCommentReason != null) {
            target.setAskBadCommentReason(askBadCommentReason);
        }
        if (StringUtils.isNotBlank(robotAnswerEvaluationSettings)) {
            target.setRobotAnswerEvaluationSettings(robotAnswerEvaluationSettings);
        }
        if (robotDialogueInputAssociation != null) {
            target.setRobotDialogueInputAssociation(robotDialogueInputAssociation);
        }
        if (useDefaultRobotAsBottomPlan != null) {
            target.setUseDefaultRobotAsBottomPlan(useDefaultRobotAsBottomPlan);
        }
    }

    /**
     * 检查基础设置是否已完成
     *
     * @param csaiRobotSettingsPO
     * @return
     */
    private boolean checkBaseSettingsDone(CsaiRobotSettingsPO csaiRobotSettingsPO) {
        return csaiRobotSettingsPO != null && StringUtils.isNotBlank(csaiRobotSettingsPO.getInternalName());
    }

    /**
     * 检查算法模块是否已配置完成
     *
     * @param csaiRobotSettingsPO
     * @return
     */
    private boolean checkAlgirithmModelDone(CsaiRobotSettingsPO csaiRobotSettingsPO) {
        // 检索模型
        boolean searchDone = csaiRobotSettingsPO.getSearchAccurateAnswerThreshold() != null
                && csaiRobotSettingsPO.getSearchRecommendAnswerThreshold() != null
                && csaiRobotSettingsPO.getSearchPriority() != null;

        // 关键词模型
        boolean keywordDone = csaiRobotSettingsPO.getKeywordAccurateAnswerThreshold() != null
                && csaiRobotSettingsPO.getKeywordPriority() != null;

        // 寒暄模型
        boolean greetingDone = csaiRobotSettingsPO.getGreetingAccurateAnswerThreshold() != null
                && csaiRobotSettingsPO.getGreetingPriority() != null;

        return searchDone && keywordDone && greetingDone;
    }

    /**
     * 检查绑定知识分类是否已完成（检索库分类和寒暄库分类只要有一个配置了就算已完成）
     *
     * @param csaiRobotSettingsPO
     * @return
     */
    private boolean checkKnowledgeCategoryDone(CsaiRobotSettingsPO csaiRobotSettingsPO) {
        String searchLibCategory = csaiRobotSettingsPO.getSearchLibCategory();
        String greetingLibCategory = csaiRobotSettingsPO.getGreetingLibCategory();
        return StringUtils.isNotBlank(searchLibCategory) || StringUtils.isNotBlank(greetingLibCategory);
    }

    /**
     * 检查入口配置管理是否已完成
     *
     * @param csaiRobotSettingsPO
     * @return
     */
    private boolean checkEntranceSourceDone(CsaiRobotSettingsPO csaiRobotSettingsPO) {
        Integer entranceCount = csaiRobotEntrancePOMapper.countRobotEntrance(csaiRobotSettingsPO.getRobotId());
        return entranceCount != null && entranceCount > 0;
    }

    /**
     * 获取机器人头像、名称基本属性
     *
     * @param csaiRobotSettingsPO
     * @return
     */
    private RobotBaseSettings getRobotBaseSettings(CsaiRobotSettingsPO csaiRobotSettingsPO) {
        // 机器人基础设置
        RobotBaseSettings robotBaseSettings = new RobotBaseSettings();
        robotBaseSettings.setLogoUrl(csaiRobotSettingsPO.getLogoUrl());
        robotBaseSettings.setInternalName(csaiRobotSettingsPO.getInternalName());
        robotBaseSettings.setExternalName(csaiRobotSettingsPO.getExternalName());
        robotBaseSettings.setRemark(csaiRobotSettingsPO.getRemark());

        return robotBaseSettings;
    }

    /**
     * 获取机器人算法能力设置（检索模型、关键词模型、寒暄模型）
     *
     * @param csaiRobotSettingsPO
     * @return
     */
    private RobotAlgorithmSettings getRobotAlgorithmSettings(CsaiRobotSettingsPO csaiRobotSettingsPO) {
        RobotAlgorithmSettings robotAlgorithmSettings = new RobotAlgorithmSettings();
        // 检索模型
        RetrievalModel retrievalModel = new RetrievalModel();
        retrievalModel.setAccurateAnswerThreshold(csaiRobotSettingsPO.getSearchAccurateAnswerThreshold());
        retrievalModel.setRecommendAnswerThreshold(csaiRobotSettingsPO.getSearchRecommendAnswerThreshold());
        retrievalModel.setPriority(csaiRobotSettingsPO.getSearchPriority());
        robotAlgorithmSettings.setRetrievalModel(retrievalModel);

        // 关键词模型
        KeywordModel keywordModel = new KeywordModel();
        keywordModel.setAccurateAnswerThreshold(csaiRobotSettingsPO.getKeywordAccurateAnswerThreshold());
        keywordModel.setPriority(csaiRobotSettingsPO.getKeywordPriority());
        robotAlgorithmSettings.setKeywordModel(keywordModel);

        // 寒暄模型
        GreetingModel greetingModel = new GreetingModel();
        greetingModel.setAccurateAnswerThreshold(csaiRobotSettingsPO.getGreetingAccurateAnswerThreshold());
        greetingModel.setPriority(csaiRobotSettingsPO.getGreetingPriority());
        robotAlgorithmSettings.setGreetingModel(greetingModel);

        return robotAlgorithmSettings;
    }

    /**
     * 获取绑定知识（检索库分类、寒暄库分类）
     *
     * @param csaiRobotSettingsPO
     * @return
     */
    private BindingKnowledgeCategory getBindingKnowledgeCategory(CsaiRobotSettingsPO csaiRobotSettingsPO) {
        BindingKnowledgeCategory bindingKnowledgeCategory = new BindingKnowledgeCategory();
        bindingKnowledgeCategory.setSearchLibCategory(csaiRobotSettingsPO.getSearchLibCategory());
        bindingKnowledgeCategory.setGreetingLibCategory(csaiRobotSettingsPO.getGreetingLibCategory());
        return bindingKnowledgeCategory;
    }

    /**
     * 获取入口配置摘要信息; 按入口id从小到大排序
     *
     * @param robotId
     * @return
     */
    private List<RobotEntranceSummary> getRobotEntranceSummary(String robotId) {
        List<RobotEntranceSummary> robotEntranceSummaryList = new ArrayList<>(); // 新建入口摘要信息对象
        List<CsaiRobotEntrancePO> csaiRobotEntrancePOList = csaiRobotEntrancePOMapper
                .selectEntranceListByRobotId(robotId);
        csaiRobotEntrancePOList.forEach(csaiRobotEntrancePO -> {
            RobotEntranceSummary robotEntranceSummary = new RobotEntranceSummary();
            BeanUtils.copyProperties(csaiRobotEntrancePO, robotEntranceSummary);
            // 入口更新时间从timestamp转成String
            String updateTime = DateUtil.formatDate(csaiRobotEntrancePO.getDbUpdateTime(), DateUtil.FMT_DATE_YYYYMMDD_HHMMSS);
            robotEntranceSummary.setUpdateTime(updateTime);
            robotEntranceSummaryList.add(robotEntranceSummary); // 添加到入口列表中
        });
        return robotEntranceSummaryList;
    }
}

