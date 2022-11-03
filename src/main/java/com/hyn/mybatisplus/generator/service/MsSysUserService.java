package com.hyn.mybatisplus.generator.service;

import com.hyn.mybatisplus.generator.entity.MsSysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */
public interface MsSysUserService extends IService<MsSysUser> {
    MsSysUser findUserById(Long id);

}
