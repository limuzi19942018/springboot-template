package com.shannonai.springboot.base.factory;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shannonai.springboot.utils.ObjectUtils;

import java.util.Map;

/**
 * BootStrap Table默认的分页参数创建
 *
 * @author ligang
 * @date 2020-10-10 17:50
 */
public class PageFactory<T> {

    public Page<T> defaultPage(Map<String,Object> paramMap) {
        //每页多少条数据
        int limit = 10;
        String limitStr = ObjectUtils.nullToStr(paramMap.get("limit"));
        if(StrUtil.isNotBlank(limitStr)){
            limit = Integer.parseInt(limitStr);
        }
        //每页的偏移量(本页当前有多少条)
        int offset = 0;
        String offsetStr = ObjectUtils.nullToStr(paramMap.get("offset"));
        if(StrUtil.isNotBlank(offsetStr)){
            offset = Integer.parseInt(offsetStr);
        }
        //当前页码
        int pageNum = 1;
        String pageStr = ObjectUtils.nullToStr(paramMap.get("pageNum"));
        if(StrUtil.isNotBlank(pageStr)){
            pageNum = Integer.parseInt(pageStr);
            if(pageNum < 1){
                pageNum = 1;
            }
        }else{
            pageNum = offset / limit + 1;
        }
        return new Page<>(pageNum, limit);
    }
}
