package com.windAndCloud.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.windAndCloud.entity.KnowledgePoint;
import com.windAndCloud.mapper.KnowledgePointMapper;
import com.windAndCloud.service.KnowledgePointService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.windAndCloud.vo.KnowledgePointVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 知识点  服务实现类
 * </p>
 *
 * @author 代号：9527
 * @since 2020-09-12
 */
@Service
@Slf4j
public class KnowledgePointServiceImpl extends ServiceImpl<KnowledgePointMapper, KnowledgePoint> implements KnowledgePointService {

    @Autowired
    KnowledgePointMapper knowledgePointMapper;
    static  List<KnowledgePointVo> knowledgePointVoList1=new ArrayList<>();
    static   int num=0;
    @Override
    public List<KnowledgePointVo> getTreeKnowled(KnowledgePointVo knowledgePointVo) {
        //查询出全部相关科目的知识点
        List<KnowledgePointVo> knowledgePointVoList = getKnowledgePointVoList(knowledgePointVo);
        log.info("**********知识点结构树***********\n{}",JSONObject.toJSONString(knowledgePointVoList));
        return knowledgePointVoList;
    }

    /**
     * 根据科目查询知识点树集合
     * @param knowledgePointVo
     * @return
     */
    public List<KnowledgePointVo> getKnowledgePointVoList(KnowledgePointVo knowledgePointVo){
        QueryWrapper<KnowledgePoint> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(KnowledgePoint::getKnowledgePointSubjectId, knowledgePointVo.getKnowledgePointSubjectId());
        List<KnowledgePoint> rootList = knowledgePointMapper.selectList(queryWrapper);
        List<KnowledgePointVo> rootLists = new ArrayList<>();
        rootList.forEach(val -> {
            KnowledgePointVo knowledgePointVo1 = new KnowledgePointVo();
            BeanUtils.copyProperties(val, knowledgePointVo1);
            rootLists.add(knowledgePointVo1);
        });
        //遍历拿到根节点 （数学）
        List<KnowledgePointVo> tree = new ArrayList<>();
        for (KnowledgePointVo node : rootLists) {
            if (node.getKnowledgePointParentId().equals("9")) {
                tree.add(findChild(node, rootLists));
            }
        }
        return tree;
    }

    /**
     * 获取知识点下拉列表
     * @param subjectId
     * @return
     */
   public List<KnowledgePointVo> treeList(String subjectId){
       knowledgePointVoList1.clear();
      //查询出全部相关科目的知识点
      QueryWrapper<KnowledgePoint> queryWrapper1 = new QueryWrapper();
      queryWrapper1.lambda().eq(KnowledgePoint::getKnowledgePointSubjectId, "1");
      List<KnowledgePoint> rootList = knowledgePointMapper.selectList(queryWrapper1);
      List<KnowledgePointVo> rootLists = new ArrayList<>();
      rootList.forEach(val -> {
          KnowledgePointVo knowledgePointVo1 = new KnowledgePointVo();
          BeanUtils.copyProperties(val, knowledgePointVo1);
          rootLists.add(knowledgePointVo1);
      });
       List<KnowledgePointVo> tree = new ArrayList<>();
       for (KnowledgePointVo node : rootLists) {
           if (node.getKnowledgePointParentId().equals("9")) {
               findTree(node, rootLists);
           }
       }
       log.info("**************知识点下拉框****************\n{}",JSONObject.parse(JSON.toJSONString(knowledgePointVoList1)));
        return knowledgePointVoList1;

  }


    static KnowledgePointVo findChild(KnowledgePointVo node, List<KnowledgePointVo> list) {
        for (KnowledgePointVo n : list) {
            if (n.getKnowledgePointParentId().equals(node.getKnowledgePointId()) ) {
                if (node.getChildNodes() == null) {
                    node.setChildNodes(new ArrayList<>());
                }
                node.getChildNodes().add(findChild(n, list));
            }
        }
        return node;

    }

    /**
     * 查询知识点下拉框
     * @param node
     * @param list
     * @return
     */

    static   void  findTree(KnowledgePointVo node, List<KnowledgePointVo> list) {
        //遍历树形集合
        list.forEach(val->{
            //如果当前对象的id 等于知识点集合的父级id，说明当前对象是有子集的，就接着递归循环，如果没有就把当前对象添加进集合
            if(val.getKnowledgePointParentId().equals(node.getKnowledgePointId())){
                //如果有相同的把当前集合对象递归
                num=1;
                findTree(val,list);
                if (num>0){
                    num=0;
                    knowledgePointVoList1.add(val);
                }
            }
        });
    }
}
