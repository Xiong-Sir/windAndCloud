package com.windAndCloud.controller;


import com.winAndCloud.entity.Result;
import com.windAndCloud.service.KnowledgePointService;
import com.windAndCloud.vo.KnowledgePointVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 知识点  前端控制器
 * </p>
 *
 * @author 代号：9527
 * @since 2020-09-12
 */
@Controller
@RequestMapping("/knowledgePoint")
public class KnowledgePointController {

    @Autowired
    KnowledgePointService knowledgePointService;

    @RequestMapping("/getTree")
    public List<KnowledgePointVo> getTreeKnowled(KnowledgePointVo knowledgePointVo) {
    return knowledgePointService.getTreeKnowled(knowledgePointVo);
    }
}

