package com.cocolegend.controller;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 购物车对应的界面
 * 已经有上下文mContext,可以直接取用
 * @author cy
 *
 */
public class ShoppingcarController extends BaseController {

	private TextView tv;
	
	public ShoppingcarController(Context context) {
		super(context);
	}

	@Override
	protected View initView(Context context) {
		tv = new TextView(context);
		return tv;
	}

	@Override
	protected void initData() {
		tv.setText("购物车");
	}

}
