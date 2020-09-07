package com.windAndCloud.entity;

import java.util.Date;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 代号：9527
 * @since 2020-09-07
 */
public class ShoppRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 更新人
     */
    private String modifier;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdatedDate;

    /**
     * 并发控制字段
     */
    private String updateControlId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getUpdateControlId() {
        return updateControlId;
    }

    public void setUpdateControlId(String updateControlId) {
        this.updateControlId = updateControlId;
    }

    @Override
    public String toString() {
        return "ShoppRole{" +
        ", id=" + id +
        ", roleName=" + roleName +
        ", remark=" + remark +
        ", creator=" + creator +
        ", createdDate=" + createdDate +
        ", modifier=" + modifier +
        ", lastUpdatedDate=" + lastUpdatedDate +
        ", updateControlId=" + updateControlId +
        "}";
    }
}
