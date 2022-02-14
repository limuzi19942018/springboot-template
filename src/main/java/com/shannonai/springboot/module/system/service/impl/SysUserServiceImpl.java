package com.shannonai.springboot.module.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shannonai.springboot.module.system.dao.SysUserMapper;
import com.shannonai.springboot.module.system.model.SysUser;
import com.shannonai.springboot.module.system.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ligang
 * @since 2021-07-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<Map<String, Object>> findPageList(Page<Map<String, Object>> page, Map<String, Object> paramMap) {
        return sysUserMapper.findPageList(page, paramMap);
    }

}
