package service;

import dao.gen.po.KeyValueJsonPO;

public interface KeyValueService {
    /**
     * 查询key-value
     * 
     * @param biz_type
     * @param key
     * @return
     */
    KeyValueJsonPO queryKeyValue(String biz_type, String key);

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
