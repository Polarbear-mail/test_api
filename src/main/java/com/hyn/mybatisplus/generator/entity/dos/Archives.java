package com.hyn.mybatisplus.generator.entity.dos;

import lombok.Data;

/**
 * @author ：Polarbear
 * @date ：Created 2022/11/4 0:23
 * @description：
 */
//   此类属于数据库衍生对象，不需要持久化，也不属于view object.
@Data
public class Archives {
    private Integer year;
    private Integer month;
    private Long count;

}
