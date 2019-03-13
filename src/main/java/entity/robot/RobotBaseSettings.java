package entity.robot;

import java.io.Serializable;

/**
 * @Description 机器人头像、昵称等基本信息设置
 * @Author lilong
 * @Date 2019-03-04 11:40
 */
public class RobotBaseSettings implements Serializable {

    private static final long serialVersionUID = 4203408710209349672L;

    /**
     * 头像
     */
    private String logoUrl;

    /**
     * 对内名称
     */
    private String internalName;

    /**
     * 对外名称
     */
    private String externalName;

    /**
     * 备注
     */
    private String remark;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getExternalName() {
        return externalName;
    }

    public void setExternalName(String externalName) {
        this.externalName = externalName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
