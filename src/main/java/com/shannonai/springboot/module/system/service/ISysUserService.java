package com.shannonai.springboot.module.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shannonai.springboot.module.system.model.SysUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ligang
 * @since 2021-07-14
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 用户分页列表
     * @param page 分页
     * @param paramMap 参数
     * @author songsl
     */
    List<Map<String,Object>> findPageList(Page<Map<String, Object>> page, Map<String,Object> paramMap);

}
