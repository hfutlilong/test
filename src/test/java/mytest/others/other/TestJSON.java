package mytest.others.other;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2018-12-14 15:12
 */
public class TestJSON {
    public static void main(String[] args) {
        String jsonStr = "{\"12214-12215-12216\":[\"10372-10554-10555\",\"10372-10554-10556\",\"10372-10554-10557\",\"10372-10588\",\"10372-10590-10591\",\"10372-10590-10593\",\"10372-10590-10595\",\"10372-11364\",\"12053-12055-12062\",\"12053-12055-12061\",\"12053-12055-12067\",\"10372-10546-10548\",\"10372-10546-10550\",\"10372-10546-10551\",\"10372-10546-10552\",\"10372-10546-10553\",\"11744-11747\",\"11744-11751\"],\"12214-12215-12585\":[\"10372-10638\",\"12053-12055-12072\"],\"12214-12215-12586\":[\"10372-10631-10632\",\"10372-10631-10633\",\"10372-10631-10634\",\"12053-12055-12070\"],\"12214-12215-12767\":[\"10372-10558-10559\",\"10372-10558-10560\",\"10372-10558-10561\",\"10372-10558-10562\",\"10372-10558-10563\",\"10372-10558-10564\",\"10372-10558-10565\",\"12053-12055-12063\",\"11744-11746\"]}";
        List<String> xxx = getCannotRepeatedWorkorderTypeList(jsonStr, "12214-12215-12000216");
        System.out.println(xxx.size());
    }

    public static List<String> getCannotRepeatedWorkorderTypeList(String jsonStr, String csaiWorkorderType) {
        List<String> cannotRepeatedTypeList = new ArrayList<>();
        if (StringUtils.isBlank(jsonStr)) {
            return cannotRepeatedTypeList;
        }
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        if (jsonObject == null || !jsonObject.containsKey(csaiWorkorderType)) {
            return cannotRepeatedTypeList;
        }
        JSONArray jsonArray = jsonObject.getJSONArray(csaiWorkorderType);
        for (Object obj : jsonArray) {
            if (obj != null) {
                cannotRepeatedTypeList.add((String)obj);
            }
        }
        return cannotRepeatedTypeList;
    }

}
