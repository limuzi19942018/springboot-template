package com.shannonai.springboot.base.tips;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 分页结果的封装(for Bootstrap Table)
 *
 * @author ligang
 * @Date 2020年09月18日 上午11:06:41
 */
public class PageInfoBT<T> {

   private int code;

   private String msg;

    // 结果集
    private List<T> data;

    // 总数
    private int count;

    public PageInfoBT(Page<T> page) {
        this.code = 200;
        this.msg  = "操作成功";
        this.data = page.getRecords();
        this.count = (int)page.getTotal();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
