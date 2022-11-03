package com.hyn.mybatisplus.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class MsArticle implements Serializable {

//    private static final long serialVersionUID=1L;
//
      @TableId(value = "id", type = IdType.AUTO)
      private Long id;
    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

      /**
     * 评论数量
     */
      private Integer commentCounts;

      /**
     * 创建时间
     */
      private Long createDate;

      /**
     * 简介
     */
      private String summary;

      /**
     * 标题
     */
      private String title;

      /**
     * 浏览数量
     */
      private Integer viewCounts;

      /**
     * 是否置顶
     */
      private Integer weight;

      /**
     * 作者id
     */
      private Long authorId;

      /**
     * 内容id
     */
      private Long bodyId;

      /**
     * 类别id
     */
      private Integer categoryId;


}
