package com.windAndCloud.entity;

import java.util.Date;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 知识点 
 * </p>
 *
 * @author 代号：9527
 * @since 2020-09-12
 */
public class KnowledgePoint implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 知识点id
     */
    private String knowledgePointId;

    /**
     * 科目id
     */
    private String knowledgePointSubjectId;

    /**
     * 父知识点
     */
    private String knowledgePointParentId;

    /**
     * 知识点名称
     */
    private String knowledgePointName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否可用
     */
    private String isAvailable;

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


    public String getKnowledgePointId() {
        return knowledgePointId;
    }

    public void setKnowledgePointId(String knowledgePointId) {
        this.knowledgePointId = knowledgePointId;
    }

    public String getKnowledgePointSubjectId() {
        return knowledgePointSubjectId;
    }

    public void setKnowledgePointSubjectId(String knowledgePointSubjectId) {
        this.knowledgePointSubjectId = knowledgePointSubjectId;
    }

    public String getKnowledgePointParentId() {
        return knowledgePointParentId;
    }

    public void setKnowledgePointParentId(String knowledgePointParentId) {
        this.knowledgePointParentId = knowledgePointParentId;
    }

    public String getKnowledgePointName() {
        return knowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName) {
        this.knowledgePointName = knowledgePointName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
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

    @Override
    public String toString() {
        return "KnowledgePoint{" +
        ", knowledgePointId=" + knowledgePointId +
        ", knowledgePointSubjectId=" + knowledgePointSubjectId +
        ", knowledgePointParentId=" + knowledgePointParentId +
        ", knowledgePointName=" + knowledgePointName +
        ", sort=" + sort +
        ", isAvailable=" + isAvailable +
        ", remark=" + remark +
        ", creator=" + creator +
        ", createdDate=" + createdDate +
        ", modifier=" + modifier +
        ", lastUpdatedDate=" + lastUpdatedDate +
        "}";
    }
}
