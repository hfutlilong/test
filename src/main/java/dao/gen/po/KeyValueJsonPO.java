package dao.gen.po;

import entity.dto.KeyValueJsonDTO;
import java.io.Serializable;
import java.util.Date;

public class KeyValueJsonPO implements Serializable {
    private Long id;

    private String bizType;

    private String key;

    private KeyValueJsonDTO value;

    private Date dbUpdateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public KeyValueJsonDTO getValue() {
        return value;
    }

    public void setValue(KeyValueJsonDTO value) {
        this.value = value;
    }

    public Date getDbUpdateTime() {
        return dbUpdateTime;
    }

    public void setDbUpdateTime(Date dbUpdateTime) {
        this.dbUpdateTime = dbUpdateTime;
    }
}