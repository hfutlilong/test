package dao.gen.mapper;

import dao.gen.po.CsaiRobotEntrancePO;

import java.util.List;
import java.util.Map;

public interface CsaiRobotEntrancePOMapperExt extends CsaiRobotEntrancePOMapper {

    /**
     * 获取
     * @param cond
     * @return
     */
    List<CsaiRobotEntrancePO> selectRepeatByUniqueKey(Map<String,Object> cond);

    /**
     * 更新机器人基本信息
     * @return
     */
    int updateCsaiRobotEntrance(CsaiRobotEntrancePO csaiRobotEntrancePO);

    /**
     * 删除入口数据
     * @param cond
     * @return
     */
    int updateSwitchById(Map<String, Object> cond);

    /**
     * 统计机器人有多少个入口配置
     *
     * @param robotId
     * @return
     */
    Integer countRobotEntrance(String robotId);

    /**
     * 获取机器人对应的所有入口配置，按创建时间排序
     *
     * @param robotId
     * @return
     */
    List<CsaiRobotEntrancePO> selectEntranceListByRobotId(String robotId);
}