package com.hyn.mybatisplus.generator.service.impl;

import com.hyn.mybatisplus.generator.entity.MsTag;
import com.hyn.mybatisplus.generator.mapper.MsTagMapper;
import com.hyn.mybatisplus.generator.service.MsTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyn.mybatisplus.generator.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
