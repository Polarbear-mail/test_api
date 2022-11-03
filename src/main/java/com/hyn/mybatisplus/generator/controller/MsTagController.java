package com.hyn.mybatisplus.generator.controller;


import com.hyn.mybatisplus.generator.entity.Result;
import com.hyn.mybatisplus.generator.mapper.MsTagMapper;
import com.hyn.mybatisplus.generator.service.MsTagService;
import com.hyn.mybatisplus.generator.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */
@RestController
@RequestMapping("tags")
public class MsTagController{

    @Autowired
    private MsTagService tagService;


    // tags/hot
    @GetMapping("hot")
    public Result ListfindhotTags(){
        int limit = 3;
        return tagService.hots(limit);
    }




}

