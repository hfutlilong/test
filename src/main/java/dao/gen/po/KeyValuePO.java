package dao.gen.po;

import common.enums.KeyValueBizTypeEnum;
import java.io.Serializable;
import java.util.Date;

public class KeyValuePO implements Serializable {
    private Long id;

    private KeyValueBizTypeEnum bizType;

    private String key;

    private String value;

    private Date createTime;

    private Date dbUpdateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KeyValueBizTypeEnum getBizType() {
        return bizType;
    }

    public void setBizType(KeyValueBizTypeEnum bizType) {
        this.bizType = bizType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDbUpdateTime() {
        return dbUpdateTime;
    }

    public void setDbUpdateTime(Date dbUpdateTime) {
        this.dbUpdateTime = dbUpdateTime;
    }
}