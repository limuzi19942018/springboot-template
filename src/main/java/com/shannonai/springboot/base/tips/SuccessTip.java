package com.shannonai.springboot.base.tips;

/**
 * 返回给前台的成功提示
 *
 * @author ligang
 * @date 2020年09月25日 下午5:22:55
 */
public class SuccessTip extends Tip {

	public SuccessTip(){
		super.code = 200;
		super.msg = "操作成功";
		super.data = null;
	}

	public SuccessTip(int code, String msg, Object data){
		super.code = code;
		super.msg = msg;
		super.data = data;
	}

	public SuccessTip(Object data){
		super.code = 200;
		super.msg = "操作成功";
		super.data = data;
	}

}
