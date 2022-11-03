package com.hyn.mybatisplus.generator.service;

import com.hyn.mybatisplus.generator.entity.MsTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyn.mybatisplus.generator.vo.TagVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */
public interface MsTagService extends IService<MsTag> {
    List<TagVo> findTagsByArticleId(Long articleId);

}
