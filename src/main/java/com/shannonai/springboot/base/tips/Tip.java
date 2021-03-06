package com.shannonai.springboot.base.tips;

/**
 * 返回给前台的提示（最终转化为json形式）
 *
 * @author ligang
 * @Date 2020年09月25日 上午11:58:00
 */
public abstract class Tip {

    protected int code;

    protected String msg;

    protected Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
