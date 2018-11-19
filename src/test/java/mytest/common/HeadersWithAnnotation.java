package mytest.common;

import utils.FileUtils;

/**
 * @Description 列名
 * @Author lilong
 * @Date 2018-11-19 16:53
 */
public class HeadersWithAnnotation {
    /**
     * 数据ID
     */
    @FileUtils.ImportCol(title = "数据ID")
    private Long id;

    /**
     * 数据内容
     */
    @FileUtils.ImportCol(title = "数据内容")
    private String content;

    /**
     * 数据所属分类
     */
    @FileUtils.ImportCol(title = "数据类别")
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
