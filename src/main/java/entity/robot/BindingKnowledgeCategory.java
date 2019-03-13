package entity.robot;

import java.io.Serializable;

/**
 * @Description 机器人绑定知识分类
 * @Author lilong
 * @Date 2019-03-04 11:42
 */
public class BindingKnowledgeCategory implements Serializable {

    private static final long serialVersionUID = -8383219333208264406L;

    /**
     * 绑定知识分类-检索库
     */
    private String searchLibCategory;

    /**
     * 绑定知识分类-寒暄库
     */
    private String greetingLibCategory;

    public String getSearchLibCategory() {
        return searchLibCategory;
    }

    public void setSearchLibCategory(String searchLibCategory) {
        this.searchLibCategory = searchLibCategory;
    }

    public String getGreetingLibCategory() {
        return greetingLibCategory;
    }

    public void setGreetingLibCategory(String greetingLibCategory) {
        this.greetingLibCategory = greetingLibCategory;
    }
}
