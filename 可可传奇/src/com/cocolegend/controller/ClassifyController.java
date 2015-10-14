package com.cocolegend.controller;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 分类页面对应的界面，
 * 已经有上下文mContext,可以直接取用
 * @author cy
 *
 */
public class ClassifyController extends BaseController {

	private TextView tv;

	public ClassifyController(Context context) {
		super(context);
	}

	@Override
	protected View initView(Context context) {
		tv = new TextView(context);
		return tv;
	}

	@Override
	protected void initData() {
		tv.setText("分类");
	}

}
