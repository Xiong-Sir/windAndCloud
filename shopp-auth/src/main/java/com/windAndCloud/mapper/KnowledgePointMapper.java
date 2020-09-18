package com.windAndCloud.mapper;

import com.windAndCloud.entity.KnowledgePoint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 知识点  Mapper 接口
 * </p>
 *
 * @author 代号：9527
 * @since 2020-09-12
 */
@Repository
@Mapper
public interface KnowledgePointMapper extends BaseMapper<KnowledgePoint> {

}
