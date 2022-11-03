package com.hyn.mybatisplus.generator.vo;



import lombok.Data;

import java.util.List;

@Data
public class ArticleVo {

    private Long id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Integer weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

//    private ArticleBodyVo body;

    // 与前端页面交互的数据，不应该和数据映射对象耦合
    private List<TagVo> tags;

//    private CategoryVo category;

}
