package com.shannonai.springboot.base.tips;

/**
 * 返回给前台的错误提示
 *
 * @author ligang
 * @date 2020年09月22日 下午3:15:39
 */
public class ErrorTip extends Tip {

    public ErrorTip(){
        super.code = 500;
        super.msg = "服务器异常";
        super.data = null;
    }

    public ErrorTip(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
        super.data = null;
    }

    public ErrorTip(int code, String msg, Object data){
        super.code = code;
        super.msg = msg;
        super.data = data;
    }

}
