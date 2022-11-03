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
    // 获取首页文章列表
    Result listArticle(PageParams pageParams);
    //获取最热文章
    Result findHotArticle(int limit);
    // 查找最新文章
    Result findNewArticle(int limit);
    // 文章归档
    Result listArchives();
}
