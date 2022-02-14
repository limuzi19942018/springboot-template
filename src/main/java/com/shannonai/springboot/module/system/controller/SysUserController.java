package com.shannonai.springboot.module.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shannonai.springboot.base.factory.PageFactory;
import com.shannonai.springboot.base.tips.PageInfoBT;
import com.shannonai.springboot.base.tips.SuccessTip;
import com.shannonai.springboot.module.system.model.SysUser;
import com.shannonai.springboot.module.system.service.ISysUserService;
import com.shannonai.springboot.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ligang
 * @since 2021-07-14
 */
@Controller
@RequestMapping("/api/sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    /***
     * @description: 查询所有用户信息
     * @return: java.lang.Object
     * @author ligang
     * @date: 2021/7/14 13:39
     */
    @RequestMapping(value="/list")
    @ResponseBody
    public Object list() throws Exception {
        List<SysUser> list = sysUserService.list();
        return new SuccessTip(list);
    }

    /***
     * @description: 保存用户信息
     * @param: paramMap 用户信息
     * @return: java.lang.Object
     * @author ligang
     * @date: 2021/7/14 13:38
     */
    @RequestMapping(value="/save")
    @ResponseBody
    public Object save(@RequestBody Map<String,Object> paramMap) {
        SysUser sysUser = BeanUtil.fillBeanWithMap(paramMap, new SysUser(), false);
        sysUser.setId(ObjectUtils.getShortUuid());
        sysUserService.save(sysUser);
        return new SuccessTip();
    }

    /***
     * @description: 用户信息分页
     * @param: paramMap 分页参数等查询信息
     * @return: java.lang.Object
     * @author ligang
     * @date: 2021/7/14 13:40
     */
    @RequestMapping(value="/findPageList")
    @ResponseBody
    public Object findPageList(@RequestBody Map<String,Object> paramMap) {
        Page<Map<String, Object>> page = new PageFactory<Map<String, Object>>().defaultPage(paramMap);
        List<Map<String, Object>> mapList = sysUserService.findPageList(page, paramMap);
        page.setRecords(mapList);
        return new PageInfoBT<>(page);
    }

    /***
     * @description:  修改用户信息
     * @param: paramMap 用户信息
     * @return: java.lang.Object
     * @author ligang
     * @date: 2021/7/14 13:46
     */
    @RequestMapping(value="/update")
    @ResponseBody
    public Object update(@RequestBody Map<String,Object> paramMap) {
        SysUser sysUser = BeanUtil.fillBeanWithMap(paramMap, new SysUser(), false);
        sysUserService.updateById(sysUser);
        return new SuccessTip();
    }

    /***
     * @description: 删除用户信息
     * @param: paramMap
     * @return: java.lang.Object
     * @author ligang
     * @date: 2021/7/14 13:47
     */
    @RequestMapping(value="/delete")
    @ResponseBody
    public Object delete(@RequestBody Map<String,Object> paramMap) {
        sysUserService.removeById((String)paramMap.get("id"));
        return new SuccessTip();
    }

}
