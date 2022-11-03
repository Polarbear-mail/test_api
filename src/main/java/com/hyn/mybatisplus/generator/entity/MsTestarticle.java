package com.hyn.mybatisplus.generator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class MsTestarticle implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private Long reportid;

    @TableField("Firstname")
    private String Firstname;

    @TableField("LastName")
    private String LastName;

    @TableField("Address")
    private String Address;

    @TableField("City")
    private String City;


}
