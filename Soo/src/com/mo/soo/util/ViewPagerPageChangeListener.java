package com.mo.soo.util;


import com.mo.soo.R;
import com.mo.soo.view.MyViewActivity;

import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ViewPagerPageChangeListener implements OnPageChangeListener{
    /*
     * state：网上通常说法：1的时候表示正在滑动，2的时候表示滑动完毕了，0的时候表示什么都没做，就是停在那；
     * 我的认为：1是按下时，0是松开，2则是新的标签页的是否滑动了
     * (例如：当前页是第一页，如果你向右滑不会打印出2，如果向左滑直到看到了第二页，那么就会打印出2了)；
     * 个人认为一般情况下是不会重写这个方法的
     */
    @Override
    public void onPageScrollStateChanged(int state) {
    }

    /*
     * page：看名称就看得出，当前页； positionOffset：位置偏移量，范围[0,1]；
     * positionoffsetPixels：位置像素，范围[0,屏幕宽度)； 个人认为一般情况下是不会重写这个方法的
     */
    @Override
    public void onPageScrolled(int page, float positionOffset,
            int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int page) {
        //更新图标
        for (int i = 0; i < MyViewActivity.list.size(); i++) {
            if (page == i) {
            	MyViewActivity. img[i].setBackgroundResource(R.drawable.sel_yes);
            } else {
            	MyViewActivity.img[i].setBackgroundResource(R.drawable.sel_no);
            }
        }
    }
}
