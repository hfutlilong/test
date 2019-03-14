package service.robot;

import common.exception.BizException;
import dao.gen.po.CsaiRobotSettingsPO;
import entity.enums.RobotTypeEnum;
import entity.robot.*;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description 机器人设置转换
 * @Author lilong
 * @Date 2019-03-13 22:55
 */
public class RobotSettingsConvert {
    /**
     * 配置机器人高级设置
     */
    public static class WriteAdvanceSettings {
        /**
         * 拷贝机器人高级设置，如果有null值则跳过
         *
         * @param source
         * @param target
         */
        public static void copyAdvancedSettingsWithoutNull(AdvancedRobotSettingsDTO source,
                                                           AdvancedRobotSettingsDTO target) {
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
    }

    /**
     * 从数据库读取机器人设置信息
     */
    public static class ReadRobotSettings {
        /**
         * 获取机器人头像、名称基本属性
         *
         * @param csaiRobotSettingsPO
         * @return
         */
        public static RobotBaseSettings getRobotBaseSettings(CsaiRobotSettingsPO csaiRobotSettingsPO) {
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
        public static RobotAlgorithmSettings getRobotAlgorithmSettings(CsaiRobotSettingsPO csaiRobotSettingsPO) {
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
        public static BindingKnowledgeCategory getBindingKnowledgeCategory(CsaiRobotSettingsPO csaiRobotSettingsPO) {
            BindingKnowledgeCategory bindingKnowledgeCategory = new BindingKnowledgeCategory();
            bindingKnowledgeCategory.setSearchLibCategory(csaiRobotSettingsPO.getSearchLibCategory());
            bindingKnowledgeCategory.setGreetingLibCategory(csaiRobotSettingsPO.getGreetingLibCategory());
            return bindingKnowledgeCategory;
        }
    }

    /**
     * 将机器人配置信息写入数据库
     */
    public static class WriteRobotSettings {
        /**
         * 将传入的机器人配置转换成数据库可直接使用的PO
         *
         * @param corpId
         * @param robotId
         * @param robotSettingsDetailDTO
         * @return
         */
        public static CsaiRobotSettingsPO convertRobotSettingsDetailDTO(Long corpId, String robotId,
                                                                        RobotSettingsDetailDTO robotSettingsDetailDTO) {
            CsaiRobotSettingsPO csaiRobotSettingsPO = new CsaiRobotSettingsPO();
            csaiRobotSettingsPO.setRobotId(robotId);
            csaiRobotSettingsPO.setCorpId(corpId);

            Integer robotType = robotSettingsDetailDTO.getRobotType();
            if (robotType != null) {
                csaiRobotSettingsPO.setRobotType(RobotTypeEnum.valueOf(robotType));
            }

            Integer robotStatus = robotSettingsDetailDTO.getRobotStatus();
            if (robotStatus != null) {
                csaiRobotSettingsPO.setRobotType(RobotTypeEnum.valueOf(robotStatus));
            }

            // 机器人头像、昵称等基本信息设置
            RobotBaseSettings robotBaseSettings = robotSettingsDetailDTO.getRobotBaseSettings();
            if (robotBaseSettings != null) {
                convertRobotBaseSettings(robotBaseSettings, csaiRobotSettingsPO);
            }

            // 机器人算法能力设置
            RobotAlgorithmSettings robotAlgorithmSettings = robotSettingsDetailDTO.getRobotAlgorithmSettings();
            if (robotAlgorithmSettings != null) {
                convertRobotAlgorithmSettings(robotAlgorithmSettings, csaiRobotSettingsPO);
            }

            // 绑定知识分类
            BindingKnowledgeCategory bindingKnowledgeCategory = robotSettingsDetailDTO.getBindingKnowledgeCategory();
            if (bindingKnowledgeCategory != null) {
                convertBindingKnowledgeCategory(bindingKnowledgeCategory, csaiRobotSettingsPO);
            }

            return csaiRobotSettingsPO;
        }

        private static void convertRobotBaseSettings(RobotBaseSettings robotBaseSettings,
                                                     CsaiRobotSettingsPO csaiRobotSettingsPO) {
            String logoUrl = robotBaseSettings.getLogoUrl();
            String internalName = robotBaseSettings.getInternalName();
            String externalName = robotBaseSettings.getExternalName();
            String remark = robotBaseSettings.getRemark();

            // TODO 如果配置了基本信息，则必须设置对内名称，这个要测下
            if (StringUtils.isBlank(internalName)) {
                throw new BizException("internalName is required.");
            }

            csaiRobotSettingsPO.setLogoUrl(logoUrl);
            csaiRobotSettingsPO.setInternalName(internalName);
            csaiRobotSettingsPO.setExternalName(externalName);
            csaiRobotSettingsPO.setRemark(remark);
        }

        private static void convertRobotAlgorithmSettings(RobotAlgorithmSettings robotAlgorithmSettings,
                                                          CsaiRobotSettingsPO csaiRobotSettingsPO) {
            RetrievalModel retrievalModel = robotAlgorithmSettings.getRetrievalModel();
            KeywordModel keywordModel = robotAlgorithmSettings.getKeywordModel();
            GreetingModel greetingModel = robotAlgorithmSettings.getGreetingModel();

            if (retrievalModel != null) {
                if (retrievalModel.getAccurateAnswerThreshold() == null
                        || retrievalModel.getRecommendAnswerThreshold() == null
                        || retrievalModel.getPriority() == null) {
                    throw new BizException("retrievalModel param not complete.");
                }

                csaiRobotSettingsPO.setSearchAccurateAnswerThreshold(retrievalModel.getAccurateAnswerThreshold());
                csaiRobotSettingsPO.setSearchRecommendAnswerThreshold(retrievalModel.getRecommendAnswerThreshold());
                csaiRobotSettingsPO.setSearchPriority(retrievalModel.getPriority());
            }

            if (keywordModel != null) {
                if (keywordModel.getAccurateAnswerThreshold() == null || keywordModel.getPriority() == null) {
                    throw new BizException("keywordModel param not complete.");
                }

                csaiRobotSettingsPO.setKeywordAccurateAnswerThreshold(keywordModel.getAccurateAnswerThreshold());
                csaiRobotSettingsPO.setKeywordPriority(keywordModel.getPriority());
            }

            if (greetingModel != null) {
                if (greetingModel.getAccurateAnswerThreshold() == null || greetingModel.getPriority() == null) {
                    throw new BizException("greetingModel param not complete.");
                }

                csaiRobotSettingsPO.setGreetingAccurateAnswerThreshold(greetingModel.getAccurateAnswerThreshold());
                csaiRobotSettingsPO.setGreetingPriority(greetingModel.getPriority());
            }
        }

        private static void convertBindingKnowledgeCategory(BindingKnowledgeCategory bindingKnowledgeCategory,
                                                            CsaiRobotSettingsPO csaiRobotSettingsPO) {
            String searchLibCategory = bindingKnowledgeCategory.getSearchLibCategory();
            String greetingLibCategory = bindingKnowledgeCategory.getGreetingLibCategory();

            csaiRobotSettingsPO.setSearchLibCategory(searchLibCategory);
            csaiRobotSettingsPO.setGreetingLibCategory(greetingLibCategory);
        }
    }
}