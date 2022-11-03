package com.hyn.mybatisplus.generator.mapper;

import com.hyn.mybatisplus.generator.entity.MsArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyn.mybatisplus.generator.entity.dos.Archives;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */

public interface MsArticleMapper extends BaseMapper<MsArticle> {

    List<Archives> listArchives();
}
