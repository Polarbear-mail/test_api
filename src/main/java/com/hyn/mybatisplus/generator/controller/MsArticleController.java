package com.hyn.mybatisplus.generator.controller;


import com.hyn.mybatisplus.generator.entity.Result;
import com.hyn.mybatisplus.generator.entity.params.PageParams;
import com.hyn.mybatisplus.generator.service.MsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */
@RestController
@RequestMapping("/articles")
public class MsArticleController {


    @Autowired
    private MsArticleService articleService;
    /**
     * 首页文章列表
     * @param pageParams
     * @return
     */

    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);


    }

}

