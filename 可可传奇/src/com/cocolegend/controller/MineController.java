package com.cocolegend.controller;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 个人信息对应的界面
 * 已经有上下文mContext,可以直接取用
 * @author cy
 *
 */
public class MineController extends BaseController {

	private TextView tv;
	
	public MineController(Context context) {
		super(context);
	}

	@Override
	protected View initView(Context context) {
		tv = new TextView(context);
		return tv;
	}

	@Override
	protected void initData() {
		tv.setText("我的");
	}

}
