package com.hyn.mybatisplus.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hyn.mybatisplus.generator.entity.MsTag;
import com.hyn.mybatisplus.generator.entity.Result;
import com.hyn.mybatisplus.generator.mapper.MsTagMapper;
import com.hyn.mybatisplus.generator.service.MsTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyn.mybatisplus.generator.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
public class MsTagServiceImpl extends ServiceImpl<MsTagMapper, MsTag> implements MsTagService {
    @Autowired
    private MsTagMapper tagMapper;




    public TagVo copy(MsTag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
    public List<TagVo> copyList(List<MsTag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (MsTag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        //mybatisplus 无法进行多表查询
        List<MsTag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        /**
         * 寻找最热标签
         * 1. 标签所有的文章越多为最热标签
         * 2. 查询 根据 tag_id 分组计数，从大到小排列，取前limit
         */
        // 1 先寻找处tagIds
        List<Long> tagIds = tagMapper.findHotTagIds(limit);
        // CollectionUtils判断集合是否为空,如果为空则返回集合空值
        if (CollectionUtils.isEmpty(tagIds)){
            return Result.success(Collections.emptyList());

        }
        //2. 需求的是tagId和对象  select * from tag where id  in (2,1,3)
        List<MsTag> tagList =  tagMapper.findTagsByIds(tagIds);
        return Result.success(tagList);
    }



}

