package com.hyn.mybatisplus.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyn.mybatisplus.generator.entity.MsArticle;
import com.hyn.mybatisplus.generator.entity.Result;
import com.hyn.mybatisplus.generator.entity.dos.Archives;
import com.hyn.mybatisplus.generator.entity.params.PageParams;
import com.hyn.mybatisplus.generator.mapper.MsArticleMapper;
import com.hyn.mybatisplus.generator.mapper.MsTagMapper;
import com.hyn.mybatisplus.generator.service.MsArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyn.mybatisplus.generator.service.MsSysUserService;
import com.hyn.mybatisplus.generator.service.MsTagService;
import com.hyn.mybatisplus.generator.vo.ArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */
@Service
public class MsArticleServiceImpl implements MsArticleService {

    @Autowired
    private MsArticleMapper articleMapper;

    @Autowired
    private MsTagService tagService;

    @Autowired
    private MsSysUserService sysUserService;




    @Override
    public Result listArticle(PageParams pageParams) {
        /**
         * 分页查询数据库得到结果
         */
        Page<MsArticle> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<MsArticle> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(MsArticle::getWeight, MsArticle::getCreateDate);
        Page<MsArticle> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<MsArticle> records = articlePage.getRecords();
        //这里不能直接返回
        List <ArticleVo> articleVoList = copyList(records,true,true);
        return Result.success(articleVoList);
    }

    @Override
    public Result findHotArticle(int limit) {
        /**
         * 查询最热文章
         */
        LambdaQueryWrapper<MsArticle> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(MsArticle::getViewCounts);
        queryWrapper.select(MsArticle::getId,MsArticle::getTitle);
        queryWrapper.last("limit "+limit);
        List<MsArticle> articles = articleMapper.selectList(queryWrapper);

        return Result.success(copyList(articles,false,false));
    }

    @Override
    public Result findNewArticle(int limit) {
        /**
         * 查找最新文章
         * 1. 根据createTime进行排序
         */
        LambdaQueryWrapper<MsArticle> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(MsArticle::getCreateDate);
        queryWrapper.select(MsArticle::getId,MsArticle::getTitle);
        queryWrapper.last("limit "+limit);
        List<MsArticle> articles = articleMapper.selectList(queryWrapper);
        return Result.success(articles);
    }

    @Override
    public Result listArchives() {
        /**
         * 进行文章的归档
         * 1. 读取数据库中文章的createDate
         * 2. 转化为年、月、日
         */
        List<Archives> archivesList = articleMapper.listArchives();
        return Result.success(archivesList);
    }


    // 将转化VO后的结果添加到copyList当中
    private List<ArticleVo> copyList(List<MsArticle> records,boolean isTag,boolean isAuthor) {
        List <ArticleVo> articleVoList = new ArrayList<>();
        for (MsArticle record : records) {
            articleVoList.add(copy(record,isTag,isAuthor));
        }

        return articleVoList;
    }

    // 用 BeanUtils.copyProperties 将artcle 标签和作者转化为VO
    private ArticleVo copy(MsArticle article, boolean isTag,boolean isAuthor){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(articleVo.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        // 并不是所有接口都需要标签和作者信息
        if (isTag){
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }
        if (isAuthor){
            Long authorId = article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserById(authorId).getNickname());
        }
        return articleVo;

    }


}


