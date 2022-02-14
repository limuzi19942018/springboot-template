package com.shannonai.springboot.base.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Request请求过滤包装
 */
public class WafRequestWrapper extends HttpServletRequestWrapper {

	private boolean filterXSS = true;

	private boolean filterSQL = true;

	public WafRequestWrapper(HttpServletRequest request, boolean filterXSS, boolean filterSQL) {
		super(request);
		this.filterXSS = filterXSS;
		this.filterSQL = filterSQL;
	}

	public WafRequestWrapper(HttpServletRequest request) {
		this(request, true, true);
	}

}
