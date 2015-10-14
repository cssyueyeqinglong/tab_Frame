package com.cocolegend.controller;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 首页对应的界面,注意本页面中已经有上下文mContext;
 * @author cy
 *
 */
public class HomeController extends BaseController {

	private TextView tv;

	public HomeController(Context context) {
		super(context);
	}

	@Override
	protected View initView(Context context) {
		tv = new TextView(context);
		return tv;
	}

	@Override
	protected void initData() {
		tv.setText("首页");
	}

}
