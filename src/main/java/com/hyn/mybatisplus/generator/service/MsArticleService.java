package com.hyn.mybatisplus.generator.service;

import com.hyn.mybatisplus.generator.entity.Result;
import com.hyn.mybatisplus.generator.entity.params.PageParams;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */

public interface MsArticleService{

    Result listArticle(PageParams pageParams);
}
