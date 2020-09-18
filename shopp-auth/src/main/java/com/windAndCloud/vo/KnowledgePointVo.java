package com.windAndCloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 知识点 
 * </p>
 *
 * @author 代号：9527
 * @since 2020-09-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KnowledgePointVo implements Serializable {

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
     * 存放子集目录
     */
  private List<KnowledgePointVo> ChildNodes;

}
