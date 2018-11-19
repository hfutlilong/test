package mytest.common;

import com.alibaba.fastjson.JSON;
import mytest.base.BaseTest;
import org.testng.annotations.Test;
import utils.FileUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Description 文件工具类测试
 * @Author lilong
 * @Date 2018-11-19 16:51
 */
public class FileUtilsTest extends BaseTest {
    /**
     * excel 2007 文件的后缀
     */
    private static final String EXCEL_2007_SUFFIX = ".xlsx";

    @Test
    public void test() throws FileNotFoundException {
        String fileName = "E:\\test.xlsx";
        List<HeadersWithAnnotation> importParamList = FileUtils.importFromFile(EXCEL_2007_SUFFIX,
                new FileInputStream(fileName), HeadersWithAnnotation.class);
        System.out.println(JSON.toJSONString(importParamList));
    }
}
