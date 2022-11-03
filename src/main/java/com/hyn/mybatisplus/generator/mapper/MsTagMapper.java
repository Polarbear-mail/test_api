package com.hyn.mybatisplus.generator.mapper;

import com.hyn.mybatisplus.generator.entity.MsTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
