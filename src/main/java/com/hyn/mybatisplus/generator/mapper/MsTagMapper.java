package com.hyn.mybatisplus.generator.mapper;

import com.hyn.mybatisplus.generator.entity.MsTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyn.mybatisplus.generator.entity.Result;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */
public interface MsTagMapper extends BaseMapper<MsTag> {
    /**
     * 根据文章ID查询标签列表
     * @param articleId
     * @return
     */
    List<MsTag> findTagsByArticleId(Long articleId);


    /**
     * 查询最热的标签 前n条
     * @param limit
     * @return
     */
    //1. 先找出id排序
    List<Long> findHotTagIds(int limit);
    //2. 根据找出的id查找name
    List<MsTag> findTagsByIds(@Param("tagIds") List<Long> tagIds);
}
