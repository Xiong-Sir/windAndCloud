package com.windAndCloud.service;

import com.windAndCloud.entity.KnowledgePoint;
import com.baomidou.mybatisplus.extension.service.IService;
import com.windAndCloud.vo.KnowledgePointVo;

import java.util.List;

/**
 * <p>
 * 知识点  服务类
 * </p>
 *
 * @author 代号：9527
 * @since 2020-09-12
 */
public interface KnowledgePointService extends IService<KnowledgePoint> {
    List<KnowledgePointVo> getTreeKnowled(KnowledgePointVo knowledgePointVo);
     List<KnowledgePointVo> treeList(String subjectId);
}
