package com.cocolegend.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.cocolegend.R;
import com.cocolegend.controller.BaseController;
import com.cocolegend.controller.ClassifyController;
import com.cocolegend.controller.HomeController;
import com.cocolegend.controller.MineController;
import com.cocolegend.controller.ShoppingcarController;
import com.cocolegend.view.NoScrollViewPager;

public class MainActivity extends Activity {

	private List<BaseController> mPagerDatas; // 显示的数据
	
	private NoScrollViewPager mViewPager; 	//主页面四个界面切换的viewPager
	private RadioGroup mRadioGroup;					//四个按钮
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mViewPager=(NoScrollViewPager) findViewById(R.id.main_vp);
		mRadioGroup=(RadioGroup) findViewById(R.id.main_radiogroup);
		
		initData();
	}
	private void initData() {
		
		mPagerDatas = new ArrayList<BaseController>();
		mPagerDatas.add(new HomeController(this));			// 首页
		mPagerDatas.add(new ClassifyController(this));			// 分类
		mPagerDatas.add(new ShoppingcarController(this));	// 购物车
		mPagerDatas.add(new MineController(this));			// 我的
		
		mViewPager.setAdapter(new MainAdapter());// --->List<数据类型>

		// 设置radioGroup监听
		mRadioGroup.setOnCheckedChangeListener(new BotomCheckedListener());

		// 设置默认值
		mRadioGroup.check(R.id.main_rb_home);
		
	}

	private class MainAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			if (mPagerDatas != null) {
				return mPagerDatas.size();
			}
			return 0;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {


			BaseController controller = mPagerDatas.get(position);

			View rootView = controller.getRootView();
			
			container.addView(rootView);

			// 数据加载
			controller.setRootData();

			return rootView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

			container.removeView((View) object);
		}
	}
	
	//当前被选中的条目
	private int mCurrentTab;
	
	private class BotomCheckedListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.main_rb_home:
				mCurrentTab = 0;
				break;
			case R.id.main_rb_classify:
				mCurrentTab = 1;
				break;
			case R.id.main_rb_shoppingcar:
				mCurrentTab = 2;
				break;
			case R.id.main_rb_mine:
				// viewpager选中第0个
				mCurrentTab = 3;
				break;

			default:
				break;
			}
			mViewPager.setCurrentItem(mCurrentTab);
			
		}
		
	}
	
	/**
	 * 切换选择的显示条目
	 */
	public void setSwitchMenu(int item){
		switch (item) {
		case 0:
			mRadioGroup.check(R.id.main_rb_home);
			break;
		case 1:
			mRadioGroup.check(R.id.main_rb_classify);
			break;
		case 2:
			mRadioGroup.check(R.id.main_rb_shoppingcar);
			break;
		case 3:
			mRadioGroup.check(R.id.main_rb_mine);
			break;

		default:
			break;
		}
	}
}
