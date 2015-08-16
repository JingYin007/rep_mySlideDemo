package com.mo.soo.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.mo.soo.R;

public class MainActivity extends SlidingFragmentActivity implements OnClickListener
{

	private boolean isExit;
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments = new ArrayList<Fragment>();

	private LinearLayout ll_tab1,ll_tab2,ll_tab3;
	private ImageButton ib_1,ib_2,ib_3;
	private TextView tv1,tv2,tv3;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// 初始化SlideMenu
		initMenu();
		// 初始化ViewPager
		initViewPager();
		setSelect(1);

	}

	private void setSelect(int i) {
		setTab(i);
		mViewPager.setCurrentItem(i);
	}

	private void initViewPager()
	{
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		Tab01 tab01 = new Tab01();
		Tab02 tab02 = new Tab02();
		Tab03 tab03 = new Tab03();
		mFragments.add(tab01);
		mFragments.add(tab02);
		mFragments.add(tab03);
		ib_1 = (ImageButton) findViewById(R.id.ib_1);
		ib_2 = (ImageButton) findViewById(R.id.ib_2);
		ib_3 = (ImageButton) findViewById(R.id.ib_3);
		
		tv1=(TextView) findViewById(R.id.tv_1);
		tv2=(TextView) findViewById(R.id.tv_2);
		tv3=(TextView) findViewById(R.id.tv_3);
		ll_tab1=(LinearLayout) findViewById(R.id.id_tab1);
		ll_tab2=(LinearLayout) findViewById(R.id.id_tab2);
		ll_tab3=(LinearLayout) findViewById(R.id.id_tab3);
		ll_tab1.setOnClickListener(this);
		ll_tab2.setOnClickListener(this);
		ll_tab3.setOnClickListener(this);
		/**
		 * 初始化Adapter
		 */
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{
			@Override
			public int getCount()
			{
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0)
			{
				return mFragments.get(arg0);
			}
		};
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				int currentItem = mViewPager.getCurrentItem();
				setTab(currentItem);
			}
			
			

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void initMenu()
	{
		
		Fragment leftMenuFragment = new MenuLeft();
		setBehindContentView(R.layout.left_menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.id_left_menu_frame, leftMenuFragment).commit();
		SlidingMenu menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT_RIGHT);
		// 设置触摸屏幕的模
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		// 设置滑动菜单视图的宽
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
//		menu.setBehindWidth()
		// 设置渐入渐出效果的
		menu.setFadeDegree(0.35f);
		// menu.setBehindScrollScale(1.0f);
		menu.setSecondaryShadowDrawable(R.drawable.shadow);
		//设置右边（二级）侧滑菜单
		menu.setSecondaryMenu(R.layout.right_menu_frame);
		Fragment rightMenuFragment = new MenuRight();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.id_right_menu_frame, rightMenuFragment).commit();
	}

	public void showLeftMenu(View view)
	{
		getSlidingMenu().showMenu();
	}

	public void showRightMenu(View view)
	{
		getSlidingMenu().showSecondaryMenu();
	}
	
	private void setTab(int currentItem) {
		resetImgs();
		// 设置图片为亮色
		// 切换内容区域
		switch (currentItem)
		{
		case 0:
			ib_1.setImageResource(R.drawable.sup5);
			tv1.setTextColor(Color.GREEN);
			break;
		case 1:
			ib_2.setImageResource(R.drawable.sup5);
			tv2.setTextColor(Color.GREEN);
			break;
		case 2:
			ib_3.setImageResource(R.drawable.sup5);
			tv3.setTextColor(Color.GREEN);
			break;
		}
	}

	private void resetImgs() {
		ib_1.setImageResource(R.drawable.sup6);
		ib_2.setImageResource(R.drawable.sup2);
		ib_3.setImageResource(R.drawable.sup4);
		tv1.setTextColor(Color.GRAY);
		tv2.setTextColor(Color.GRAY);
		tv3.setTextColor(Color.GRAY);
		
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode==KeyEvent.KEYCODE_BACK) {
			
			if (isExit) {
				MainActivity.this.finish();
			} else {
				Toast.makeText(getApplicationContext(), "再按一下，就会退出！", Toast.LENGTH_SHORT).show();
				isExit= true;
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						isExit=false;
					}
				}, 3000);
			}
		}
		return false;
	}
	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
		case R.id.id_tab1:
			setSelect(0);
			break;
		case R.id.id_tab2:
			setSelect(1);
			break;
		case R.id.id_tab3:
			setSelect(2);
			break;

		default:
			break;
		}
	}
}
