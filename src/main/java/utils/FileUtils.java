package utils;

import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import common.constants.LogConstant;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/**
 * 文件工具类
 */
public class FileUtils {

    /**
     * 广义的基本类型
     */
    private static final List<String> PRIMITIVE_TYPES = Arrays.asList("java.lang.Integer", "java.lang.Double",
            "java.lang.Float", "java.lang.Long", "java.lang.Short", "java.lang.Byte", "java.lang.Boolean",
            "java.lang.Character", "java.lang.String", "int", "double", "long", "short", "byte", "boolean", "char",
            "float");

    /**
     * 浮点型类型
     */
    private static final List<String> FLOATING_TYPES = Arrays.asList("java.lang.Double", "java.lang.Float", "double",
            "float");

    private static final List<String> EXCEL_EXTENSIONS = Arrays.asList(".xls", ".xlsx");

    private static final String TXT_EXTENSION = ".txt";

    /**
     * 需要导入的列
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ImportCol {
        // 该列的标题
        String title() default "";
    }

    /**
     * 需要导出的列
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExportCol {
        // 该列的标题
        String title() default "默认标题";
    }

    static {// 覆盖转化失败时设置默认值的转化器，也可以注册自定义转化器
        ConvertUtils.register(new BooleanConverter(), Boolean.TYPE);
        ConvertUtils.register(new ByteConverter(), Byte.TYPE);
        ConvertUtils.register(new CharacterConverter(), Character.TYPE);
        ConvertUtils.register(new DoubleConverter(), Double.TYPE);
        ConvertUtils.register(new FloatConverter(), Float.TYPE);
        ConvertUtils.register(new IntegerConverter(), Integer.TYPE);
        ConvertUtils.register(new LongConverter(), Long.TYPE);
        ConvertUtils.register(new ShortConverter(), Short.TYPE);
        ConvertUtils.register(new BigDecimalConverter(), BigDecimal.class);
        ConvertUtils.register(new BigIntegerConverter(), BigInteger.class);
        ConvertUtils.register(new BooleanConverter(), Boolean.class);
        ConvertUtils.register(new ByteConverter(), Byte.class);
        ConvertUtils.register(new CharacterConverter(), Character.class);
        ConvertUtils.register(new DoubleConverter(), Double.class);
        ConvertUtils.register(new FloatConverter(), Float.class);
        ConvertUtils.register(new IntegerConverter(), Integer.class);
        ConvertUtils.register(new LongConverter(), Long.class);
        ConvertUtils.register(new ShortConverter(), Short.class);
        ConvertUtils.register(new StringConverter(), String.class);
    }

    /**
     * 利用反射做导出
     *
     * @param excelDataList 需要导出的数据列表
     * @param excelDataList sheet表名
     * @return excel文件对象
     */
    public static <T> File exportToExcel(List<T> excelDataList, String sheetName) {
        if (CollectionUtils.isEmpty(excelDataList)) {
            LogConstant.BUS.error(
                    "doExportByPoJo fail,because excelDataList is empty or the class of dataItem is not be specified");
            return null;
        }
        // 获取导出字段
        Class clazz = excelDataList.get(0).getClass();
        List<Field> allExportFields = getAnnotatedFields(clazz, ExportCol.class, true);
        if (CollectionUtils.isEmpty(allExportFields)) {
            LogConstant.BUS.error("doExportByPoJo fail,because exportFields is empty");
            return null;
        }
        // 获取导出字段的标题
        List<String> titles = new ArrayList<>();
        for (Field field : allExportFields) {
            ExportCol exportCol = field.getAnnotation(ExportCol.class);
            titles.add(exportCol.title());
        }
        return doExportByReflection(titles, excelDataList, sheetName);
    }

    /**
     * 导出到txt文件
     *
     * @param dataList 需要导出的数据列表
     * @return txt文件对象
     */
    public static <T> File exportToTxt(List<T> dataList) throws IOException {
        if (CollectionUtils.isEmpty(dataList)) {
            LogConstant.BUS.error("exportToTxt fail,because dataList is empty");
            return null;
        }
        // 取列表中第一个元素的类型
        Class clazz = dataList.get(0).getClass();
        // 获取需要导出的字段
        List<Field> exportFieldList = getAnnotatedFields(clazz, ExportCol.class, false);
        if (CollectionUtils.isEmpty(exportFieldList)) {
            LogConstant.BUS.error("exportToTxt fail,because there is no any field need to export");
            return null;
        }
        // 创建文件
        File txtFile = new File(UUID.randomUUID() + ".txt");
        if (!txtFile.createNewFile()) {
            LogConstant.BUS.error("exportToTxt fail,because create a new txt file fail");
            return null;
        }
        // 向文件中写数据
        FileWriter fileWriter = new FileWriter(txtFile, true);
        try {
            for (T data : dataList) {
                StringBuilder lineSB = new StringBuilder();
                for (Field field : exportFieldList) {
                    List filedValueList = getFieldValue(field, data);
                    if (CollectionUtils.isNotEmpty(filedValueList)) {
                        lineSB.append(filedValueList.get(0).toString());
                    }
                    lineSB.append("\t");
                }
                lineSB.append(System.lineSeparator());
                fileWriter.write(lineSB.toString());
            }
            fileWriter.flush();
        } finally {
            fileWriter.close();
        }
        return txtFile;
    }

    /**
     * 从文件导入到对象
     *
     * @param extName 文件扩展名，支持.txt，.xls，.xlsx
     * @param inputStream 文件输入流
     * @param targetClazz 导入的对象类型
     * @param <T>
     * @return
     */
    public static <T> List<T> importFromFile(String extName, InputStream inputStream, Class<T> targetClazz) {
        if (null == inputStream || null == targetClazz) {
            LogConstant.BUS.error("importFromFile fail:invalid parameter");
            return null;
        }
        List<Field> importFieldList = getAnnotatedFields(targetClazz, ImportCol.class, false);
        if (CollectionUtils.isEmpty(importFieldList)) {
            LogConstant.BUS.error("no found any field need to import,ClassName:{}", targetClazz.toString());
            return null;
        }
        List<Field> validFieldList = new ArrayList<>();
        for (Field field : importFieldList) {
            // 剔除非基本类型字段
            if (!PRIMITIVE_TYPES.contains(field.getType().getName())) {
                continue;
            }
            validFieldList.add(field);
        }
        if (CollectionUtils.isEmpty(validFieldList)) {
            LogConstant.BUS.error("no found any field need to import,ClassName:{}", targetClazz.toString());
            return null;
        }
        if (EXCEL_EXTENSIONS.contains(extName)) {
            return importFromExcelFile(inputStream, targetClazz, validFieldList);
        } else if (TXT_EXTENSION.equals(extName)) {
            return importFromTxtFile(inputStream, targetClazz, validFieldList);
        } else {
            LogConstant.BUS.error("importFromFile fail:unsupport file tpye");
        }
        return null;
    }

    private static <T> List<T> importFromExcelFile(InputStream inputStream, Class<T> clazz,
                                                   List<Field> validFieldList) {
        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = new XSSFWorkbook(inputStream);
            Sheet sheet = xssfWorkbook.getSheetAt(0);
            Row firstRow = sheet.getRow(0);
            int colCount = firstRow.getPhysicalNumberOfCells();
            int totalRowCount = sheet.getLastRowNum();
            List<T> resultList = new ArrayList<>();
            for (int rowIndex = 1; rowIndex <= totalRowCount; rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (null == row) {
                    continue;
                }
                T targetInstance = clazz.newInstance();
                // 至少一个字段有值
                boolean oneFieldHasValueAtLeast = false;
                for (int cellIndex = 0; cellIndex < Math.min(colCount, validFieldList.size()); cellIndex++) {
                    String tiltle = firstRow.getCell(cellIndex).getStringCellValue();
                    Cell cell = row.getCell(cellIndex);
                    if (null == cell) {
                        continue;
                    }
                    Field targetField = getTargetFieldByTitle(validFieldList, tiltle);
                    if (null == targetField) {
                        continue;
                    }

                    try {
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            if (FLOATING_TYPES.contains(targetField.getType().getName())) {
                                // 如果目标类型是浮点型
                                setFieldValue(targetField, targetInstance,
                                        ConvertUtils.convert(cell.getNumericCellValue(), targetField.getType()));
                            } else {
                                // cell类型为数字时，读取出来为科学计数法的double型，这里做去除科学计数法处理
                                BigDecimal temp = new BigDecimal(cell.getNumericCellValue());
                                setFieldValue(targetField, targetInstance,
                                        ConvertUtils.convert(temp.longValue(), targetField.getType()));
                            }
                        } else {
                            setFieldValue(targetField, targetInstance,
                                    ConvertUtils.convert(cell.toString(), targetField.getType()));
                        }
                        oneFieldHasValueAtLeast = true;
                    } catch (Exception e) {
                        LogConstant.BUS.error(
                                "convert cell value to field type:{} fail,rowIndex:{},cellIndex:{},cellValue:{},skip it",
                                targetField.getType().getName(), rowIndex, cellIndex, cell.toString(), e);
                    }
                }
                if (oneFieldHasValueAtLeast) {
                    resultList.add(targetInstance);
                }
            }
            return resultList;
        } catch (Exception e) {
            LogConstant.BUS.error("importFromExcelFile fail", e);
        } finally {
            // 关闭其中之一即可，无需重复关闭
            try {
                if (null != xssfWorkbook) {
                    xssfWorkbook.close();
                } else {
                    inputStream.close();
                }
            } catch (IOException e) {
                LogConstant.BUS.error("inputStream close fail", e);
            }
        }
        return null;
    }

    private static <T> List<T> importFromTxtFile(InputStream inputStream, Class<T> targetClazz,
                                                 List<Field> validFieldList) {
        BOMInputStream bomInputStream = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        try {
            bomInputStream = new BOMInputStream(inputStream);
            // 读取文件
            isr = new InputStreamReader(bomInputStream);
            br = new BufferedReader(isr);
            String line;
            List<T> resultList = new ArrayList<>();
            String[] titleLineArray = null;
            boolean isTitleLine = true;
            while ((line = br.readLine()) != null) {
                if (StringUtils.isBlank(line)) {
                    continue;
                }
                if(isTitleLine){
                    isTitleLine = false;
                    titleLineArray = line.split("\\s+");
                    continue;
                }
                T targetInstance = targetClazz.newInstance();
                // 以任何不可见字符分割
                String[] lineArray = line.split("\\s+");
                // 至少一个字段有值
                boolean oneFieldHasValueAtLeast = false;
                for (int i = 0; i < Math.min(lineArray.length, titleLineArray.length); i++) {
                    Field targetField = getTargetFieldByTitle(validFieldList, titleLineArray[i]);
                    if (null == targetField) {
                        continue;
                    }

                    try {
                        setFieldValue(targetField, targetInstance,
                                ConvertUtils.convert(lineArray[i], targetField.getType()));
                        oneFieldHasValueAtLeast = true;
                    } catch (Exception e) {
                        LogConstant.BUS.error("convert {} to field Type:{} fail,skip it", lineArray[i],
                                targetField.getType().getName(), e);
                    }
                }
                if (oneFieldHasValueAtLeast) {
                    resultList.add(targetInstance);
                }
            }
            return resultList;
        } catch (Exception e) {
            LogConstant.BUS.error("importFromTxtFile fail", e);
        } finally {
            // 关闭其中之一即可，无需重复关闭
            try {
                if (null != br) {
                    br.close();
                } else {
                    if (null != isr) {
                        isr.close();
                    } else if (null != bomInputStream) {
                        bomInputStream.close();
                    } else {
                        inputStream.close();
                    }
                }
            } catch (IOException e) {
                LogConstant.BUS.error("close io fail", e);
            }
        }
        return null;
    }

    /**
     * 根据标题名字找到对应的字段
     * @param validFieldList
     * @param title
     * @return
     */
    private static Field getTargetFieldByTitle(List<Field> validFieldList, String title) {
        for (Field field : validFieldList) {
            ImportCol importCol = field.getAnnotation(ImportCol.class);
            if(null == importCol){
                continue;
            }
            if (StringUtils.isNotBlank(importCol.title())&& importCol.title().equals(title)) {
                return field;
            }
        }
        return null;
    }

    /**
     * 合并单元格：无返回值以提高速度
     *
     * @param sheet
     * @param region
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private static void addMergedRegion(Sheet sheet, CellRangeAddress region)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        CTWorksheet worksheet = null;
        if (sheet instanceof SXSSFSheet) {
            Field fieldTmp = sheet.getClass().getDeclaredField("_sh");
            fieldTmp.setAccessible(true);
            XSSFSheet xSSFSheet = (XSSFSheet) fieldTmp.get(sheet);
            Field field = xSSFSheet.getClass().getDeclaredField("worksheet");
            field.setAccessible(true);
            worksheet = (CTWorksheet) field.get(xSSFSheet);
        } else if (sheet instanceof XSSFSheet) {
            Field field = sheet.getClass().getDeclaredField("worksheet");
            field.setAccessible(true);
            worksheet = (CTWorksheet) field.get(sheet);
        } else if (sheet instanceof HSSFSheet) {
            sheet.addMergedRegion(region);
            return;
        }
        CTMergeCells ctMergeCells = worksheet.isSetMergeCells() ? worksheet.getMergeCells()
                : worksheet.addNewMergeCells();
        CTMergeCell ctMergeCell = ctMergeCells.addNewMergeCell();
        ctMergeCell.setRef(region.formatAsString());
    }

    private static <T> File doExportByReflection(List<String> titles, List<T> excelDataList, String sheetName) {
        if (StringUtils.isBlank(sheetName)) {
            sheetName = "默认";
        }
        FileOutputStream fileOutputStream = null;
        SXSSFWorkbook sxssfWorkbook = null;
        try {
            String fileName = UUID.randomUUID().toString() + ".xlsx";
            File file = new File(fileName);
            if (!file.exists()) {
                boolean createSucc = file.createNewFile();
                if (!createSucc) {
                    LogConstant.BUS.error("create new file fail,fileName:{}", file.getName());
                    return file;
                }
            }

            sxssfWorkbook = new SXSSFWorkbook();
            SXSSFSheet sheet = (SXSSFSheet) sxssfWorkbook.createSheet(sheetName);
            Row titleRow = sheet.createRow(0);
            int i = 0;
            for (String title : titles) {
                titleRow.createCell(i).setCellValue(title);
                i++;
            }
            // 超过500条则刷到磁盘中，减少内存占用
            sheet.setRandomAccessWindowSize(500);
            // 利用反射写数据
            writeExportFieldsValToCell(sheet, 1, 0, excelDataList);
            // 写文件
            fileOutputStream = new FileOutputStream(file);
            sxssfWorkbook.write(fileOutputStream);
            return file;
        } catch (Exception e) {
            LogConstant.BUS.error("doExportByReflection fail", e);
        } finally {
            if (null != sxssfWorkbook) {
                try {
                    sxssfWorkbook.close();
                } catch (IOException e) {
                    LogConstant.BUS.error("workbook close fail", e);
                }
            }
            if (null != fileOutputStream) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    LogConstant.BUS.error("fileOutputStream close fail", e);
                }
            }
        }
        return null;
    }

    /**
     * 将导出字段的值写入cell中，此段代码复杂度较高。 支持情况说明：完美支持简单数据结构（导出的对象中均是基本类型字段）的导出，支持一对多关系的数据结构导出，支持单元格合并；
     * 理论支持复杂数据结构（多对多关系或者字段类型为嵌套的复杂类型） 大体逻辑是:判断字段的类型（如果字段为集合，则取集合中元素的类型）是基本类型或者复杂类型 如为基本类型则直接写值；如为复杂类型则递归处理
     *
     * @param sheet
     * @param fieldsStartRowNo 开始行号
     * @param fieldsStartColNo 开始列号
     * @param excelDataList
     * @param <T>
     * @return
     */
    private static <T> void writeExportFieldsValToCell(Sheet sheet, int fieldsStartRowNo, int fieldsStartColNo,
                                                       List<T> excelDataList) throws NoSuchFieldException, IllegalAccessException {
        if (null == sheet || CollectionUtils.isEmpty(excelDataList)) {
            return;
        }
        // 取第一个元素的类型为准
        Class clazz = excelDataList.get(0).getClass();
        // 所有需要导出的字段（由于这里是递归处理，所以不需要包括复杂字段类型类型中嵌套的字段）
        List<Field> exportFields = getAnnotatedFields(clazz, ExportCol.class, false);
        // 开始列号
        int colNo = fieldsStartColNo;
        for (T excelData : excelDataList) {// 所有需要导出的数据行
            int perDataStartRowNo = fieldsStartRowNo;
            int maxFieldValCount = 0;
            boolean needMergeCol = false;
            // 需要合并单元格的列
            List<Integer> needMergeRegionColNo = new ArrayList<>();
            // 下面这个for循环写一条数据记录。每条数据记录可能占用多行（复杂的字段类型，如list类型）
            for (Field exportField : exportFields) {// 遍历所有需要导出的字段
                // 当前字段开始写行号
                int fieldRowNo = perDataStartRowNo;
                // 获取该字段的值，统一转成list处理
                List fieldValues = getFieldValue(exportField, excelData);
                Class fieldClazz = exportField.getType();
                // 是集合就取集合中元素的类型，默认类型为第一个元素的类型
                if (isCollectionType(fieldClazz)) {
                    fieldClazz = getElementTypeInCollection(exportField,
                            CollectionUtils.isEmpty(fieldValues) ? null : fieldValues.get(0).getClass());
                }
                if (null == fieldClazz) {
                    continue;
                }
                if (null == fieldValues) {
                    fieldValues = new ArrayList();
                }
                // 记录占用一行的列号
                if (fieldValues.size() <= 1) {
                    needMergeRegionColNo.add(colNo);
                } else {
                    // 该条记录中有一对多的关系，故需要合并单元格
                    needMergeCol = true;
                }
                // 字段类型或者集合中元素类型为可直接写入cell中的类型
                if (PRIMITIVE_TYPES.contains(fieldClazz.getName())) {
                    for (int i = 0; i < fieldValues.size(); i++) {
                        Row curRow = sheet.getRow(fieldRowNo);
                        if (null == curRow) {
                            curRow = sheet.createRow(fieldRowNo);
                        }
                        fieldRowNo++;
                        curRow.createCell(colNo).setCellValue(fieldValues.get(i).toString());
                    }
                    colNo++;
                } else {// 字段为复杂类型，则递归
                    List<Field> nestExportFields = getAnnotatedFields(fieldClazz, ExportCol.class, false);
                    if (CollectionUtils.isNotEmpty(nestExportFields)) {
                        writeExportFieldsValToCell(sheet, fieldRowNo, colNo, fieldValues);
                        colNo += nestExportFields.size();
                    }
                }
                // 获取该字段占用的最大行数
                int fieldValCount = recurseGetFieldMaxRowCount(fieldValues);
                if (fieldValCount > maxFieldValCount) {
                    maxFieldValCount = fieldValCount;
                }
            }
            int newFieldsStartRowNo = fieldsStartRowNo + maxFieldValCount;
            if (needMergeCol) {
                // 合并单元格
                for (Integer mergeRegionCol : needMergeRegionColNo) {
                    addMergedRegion(sheet, new CellRangeAddress(fieldsStartRowNo, newFieldsStartRowNo - 1,
                            mergeRegionCol, mergeRegionCol));
                }
            }
            // 新行的开始行号
            fieldsStartRowNo = newFieldsStartRowNo;
            // 写完一条数据记录需要重置列索引
            colNo = fieldsStartColNo;
        }
    }

    /**
     * 递归计算出该字段值最多占用的行数
     *
     * @param fieldValues
     * @return
     */
    private static int recurseGetFieldMaxRowCount(List fieldValues) {
        if (CollectionUtils.isEmpty(fieldValues)) {
            return 0;
        }
        Class clazz = fieldValues.get(0).getClass();
        if (PRIMITIVE_TYPES.contains(clazz.getName())) {
            return fieldValues.size();
        }
        int result = 0;
        List<Field> exportFields = getAnnotatedFields(clazz, ExportCol.class, false);
        if (CollectionUtils.isNotEmpty(exportFields)) {
            for (Object val : fieldValues) {
                int maxFieldValCount = 0;
                for (Field exportField : exportFields) {
                    List itemFieldValues = getFieldValue(exportField, val);
                    int itemFieldMaxRowCount = recurseGetFieldMaxRowCount(itemFieldValues);
                    if (itemFieldMaxRowCount > maxFieldValCount) {
                        maxFieldValCount = itemFieldMaxRowCount;
                    }
                }
                result += maxFieldValCount;
            }
        }
        return result;
    }

    /**
     * 利用反射获取get方法再调用该方法取值
     *
     * @param field
     * @param invoker
     * @return
     */
    private static List getFieldValue(Field field, Object invoker) {
        String fieldName = field.getName();
        Class declaringClass = field.getDeclaringClass();
        Object fieldValue = null;
        if (StringUtils.isNotBlank(fieldName) && null != declaringClass && null != invoker) {
            try {
                PropertyDescriptor pd = new PropertyDescriptor(fieldName, declaringClass);
                Method getMethod = pd.getReadMethod();
                if (null != getMethod) {
                    fieldValue = getMethod.invoke(invoker);
                } else {
                    LogConstant.BUS.error("can not find the Get Method of field:" + fieldName);
                }
            } catch (Exception e) {
                LogConstant.BUS.error("getFieldValue fail", e);
            }
        }
        return convertToValList(fieldValue);
    }

    /**
     * 利用反射获取set方法再调用该方法设值
     *
     * @param field
     * @param invoker
     * @return
     */
    private static void setFieldValue(Field field, Object invoker, Object... params) throws Exception {
        String fieldName = field.getName();
        Class declaringClass = field.getDeclaringClass();
        if (StringUtils.isNotBlank(fieldName) && null != declaringClass && null != invoker) {
            PropertyDescriptor pd = new PropertyDescriptor(fieldName, declaringClass);
            Method setMethod = pd.getWriteMethod();
            if (null != setMethod) {
                setMethod.invoke(invoker, params);
            } else {
                LogConstant.BUS.error("can not find the set Method of field:" + fieldName);
            }
        }
    }

    private static List convertToValList(Object fieldValue) {
        List eleDataList = new ArrayList();
        if (null != fieldValue) {
            if (fieldValue instanceof List) {
                eleDataList = (List) fieldValue;
            } else if (fieldValue.getClass().isArray()) {
                int length = Array.getLength(fieldValue);
                for (int i = 0; i < length; i++) {
                    eleDataList.add(Array.get(fieldValue, i));
                }
            } else {
                eleDataList.add(fieldValue);
            }
        }
        return eleDataList;
    }

    /**
     * 获取集合中元素的类型,list必须指定泛型类型
     *
     * @param field
     * @param defaultType
     * @return
     */
    private static Class getElementTypeInCollection(Field field, Class defaultType) {
        Class elementType = defaultType;
        if (field.getType().isArray()) {// 数组
            elementType = field.getType().getComponentType();
        } else if (List.class.isAssignableFrom(field.getType())
                && field.getGenericType() instanceof ParameterizedType) { // 必须是泛型类型
            elementType = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
        }
        return elementType;
    }

    /**
     * 获取被目标注解类型注解的字段,递归模式可选
     *
     * @param targetClazz 目标类型
     * @param annoClazz 注解类型
     * @param recurse 是否需要递归
     * @return
     */
    private static List<Field> getAnnotatedFields(Class targetClazz, Class annoClazz, boolean recurse) {
        if (null == targetClazz) {
            return null;
        }
        Field[] declaredFields = targetClazz.getDeclaredFields();
        if (null == declaredFields || declaredFields.length <= 0) {
            LogConstant.BUS.error("the Class:{} does not declaring any field", targetClazz.toString());
            return null;
        }
        // 筛选出被注解标记的字段
        List<Field> annotationFields = new ArrayList<>();
        for (Field field : declaredFields) {
            if (null == field.getAnnotation(annoClazz)) {// 不带注解标记跳过
                continue;
            }
            Class fieldClazz = field.getType();
            if (isCollectionType(fieldClazz)) {// 如果是集合类型，则取集合中元素类型
                fieldClazz = getElementTypeInCollection(field, null);
            }
            if (null == fieldClazz || isCollectionType(fieldClazz)) {
                continue;
            }
            if (!PRIMITIVE_TYPES.contains(fieldClazz.getName()) && recurse) {// 不是基本类型且不是集合类型则递归获取
                List<Field> nestFieldList = getAnnotatedFields(fieldClazz, annoClazz, recurse);
                if (CollectionUtils.isNotEmpty(nestFieldList)) {
                    annotationFields.addAll(nestFieldList);
                }
            } else {
                annotationFields.add(field);
            }
        }
        return annotationFields;
    }

    private static boolean isCollectionType(Class clazz) {
        return null != clazz && (List.class.isAssignableFrom(clazz) || clazz.isArray());
    }
}
