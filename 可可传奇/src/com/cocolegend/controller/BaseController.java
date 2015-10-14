package com.cocolegend.controller;

import android.content.Context;
import android.view.View;

public abstract class BaseController {
	
	protected View mRootView;
	protected Context mContext;

	public BaseController(Context context) {
		this.mContext = context;
		// 加载显示的视图
		mRootView = initView(context);
	}

	/**
	 * 初始化view显示
	 * 
	 * @return
	 */
	protected abstract View initView(Context context);
	
	/**
	 * 初始化数据
	 * 
	 */
	protected abstract void initData();

	/**
	 * 获得控制器对应的根布局
	 * 
	 * @return
	 */
	public View getRootView() {
		return mRootView;
	}

	/**
	 * 加载数据的方法，如果资料有数据加载，就复写此方法
	 */
	public void setRootData() {
		initData();
	}
}
