package com.hyn.mybatisplus.generator.service.impl;

import com.hyn.mybatisplus.generator.entity.MsSysUser;
import com.hyn.mybatisplus.generator.mapper.MsSysUserMapper;
import com.hyn.mybatisplus.generator.service.MsSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyn
 * @since 2022-11-02
 */
@Service
public class MsSysUserServiceImpl extends ServiceImpl<MsSysUserMapper, MsSysUser> implements MsSysUserService {

    @Autowired
    private MsSysUserMapper sysUserMapper;
    @Override
    public MsSysUser findUserById(Long id) {
        MsSysUser sysUser =  sysUserMapper.selectById(id);
        if (sysUser == null){
            sysUser = new MsSysUser();
            sysUser.setNickname("mszlu");
        }
        return sysUser;
    }
}
