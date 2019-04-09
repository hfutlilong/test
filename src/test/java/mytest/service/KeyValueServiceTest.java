package mytest.service;

import com.alibaba.fastjson.JSON;
import dao.gen.po.KeyValueJsonPO;
import entity.dto.KeyValueJsonDTO;
import mytest.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import service.KeyValueService;

import java.util.List;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-04-03 16:48
 */
public class KeyValueServiceTest extends BaseTest {
    @Autowired
    private KeyValueService keyValueService;

    @Test
    public void testQueryKeyValue() {
        KeyValueJsonPO keyValueJsonPO = keyValueService.queryKeyValue("2B", "A1");
        System.out.println(JSON.toJSONString(keyValueJsonPO));
    }

    @Test
    public void testInsertKeyValue() {
        KeyValueJsonDTO keyValueJsonDTO = new KeyValueJsonDTO();
        keyValueJsonDTO.setId(1);
        keyValueJsonDTO.setName("美男子");
        keyValueJsonDTO.setPrice(0.618);

        KeyValueJsonPO keyValueJsonPO = new KeyValueJsonPO();
        keyValueJsonPO.setBizType("2B");
        keyValueJsonPO.setKey("A1");
        keyValueJsonPO.setValue(keyValueJsonDTO);
        keyValueService.insertKeyValue(keyValueJsonPO);
    }

    @Test
    public void testQueryKvJsonList() {
        List<KeyValueJsonPO> keyValueJsonPOList = keyValueService.queryKvJsonList();
        System.out.println("#############" + JSON.toJSONString(keyValueJsonPOList));
    }
}
