package com.windAndCloud.entity;

import java.util.Date;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 代号：9527
 * @since 2020-09-07
 */
public class ShoppAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 角色名称
     */
    @TableField("authName")
    private String authName;

    /**
     * 一个角色访问某一 url 
     */
    private String url;

    /**
     * 角色唯一标识

     */
    private String roleId;

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

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
        return "ShoppAuth{" +
        ", id=" + id +
        ", authName=" + authName +
        ", url=" + url +
        ", roleId=" + roleId +
        ", remark=" + remark +
        ", creator=" + creator +
        ", createdDate=" + createdDate +
        ", modifier=" + modifier +
        ", lastUpdatedDate=" + lastUpdatedDate +
        ", updateControlId=" + updateControlId +
        "}";
    }
}
