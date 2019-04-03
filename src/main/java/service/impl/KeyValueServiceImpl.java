package service.impl;

import dao.gen.mapper.KeyValueJsonPOMapperExt;
import dao.gen.po.KeyValueJsonPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.KeyValueService;

/**
 * @Description key-value
 * @Author lilong
 * @Date 2019-04-03 16:45
 */
@Service
public class KeyValueServiceImpl implements KeyValueService {
    @Autowired
    private KeyValueJsonPOMapperExt keyValueJsonPOMapper;

    @Override
    public KeyValueJsonPO queryKeyValue(String biz_type, String key) {
        return keyValueJsonPOMapper.queryKeyValue(biz_type, key);
    }

    @Override
    public int updateKeyValue(KeyValueJsonPO keyValueJsonPO) {
        return keyValueJsonPOMapper.updateKeyValue(keyValueJsonPO);
    }

    @Override
    public int insertKeyValue(KeyValueJsonPO keyValueJsonPO) {
        return keyValueJsonPOMapper.insertKeyValue(keyValueJsonPO);
    }
}
