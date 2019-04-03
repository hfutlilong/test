package dao.gen.mapper;

import dao.gen.po.KeyValueJsonPO;
import org.apache.ibatis.annotations.Param;

public interface KeyValueJsonPOMapperExt extends KeyValueJsonPOMapper {
    /**
     * 查询key-value
     * 
     * @param biz_type
     * @param key
     * @return
     */
    KeyValueJsonPO queryKeyValue(@Param("bizType") String biz_type, @Param("key")String key);

    /**
     * 更新key-value
     * 
     * @param keyValueJsonPO
     * @return
     */
    int updateKeyValue(KeyValueJsonPO keyValueJsonPO);

    /**
     * 插入key-value
     * 
     * @param keyValueJsonPO
     * @return
     */
    int insertKeyValue(KeyValueJsonPO keyValueJsonPO);

}
