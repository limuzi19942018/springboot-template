package com.shannonai.springboot.module.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shannonai.springboot.module.system.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ligang
 * @since 2021-07-14
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 用户分页列表
     * @param page 分页
     * @param paramMap 参数
     * @author songsl
     */
    List<Map<String,Object>> findPageList(Page<Map<String, Object>> page, @Param("paramMap") Map<String,Object> paramMap);

}
