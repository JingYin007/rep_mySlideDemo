package com.mo.soo.view;

import java.util.ArrayList;
import java.util.List;

import com.mo.soo.R;
import com.mo.soo.util.ViewPagerPageChangeListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MyViewActivity extends Activity{

	 
    private static final String TAG = "test";
    private ViewPager viewpager = null;
    public static List<View> list = null;
    public static ImageView[] img = null;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_viewpager);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        list = new ArrayList<View>();
        list.add(getLayoutInflater().inflate(R.layout.my_img, null));
        list.add(getLayoutInflater().inflate(R.layout.my_img2, null));
        list.add(getLayoutInflater().inflate(R.layout.my_img3, null));
 
        img = new ImageView[list.size()];
        LinearLayout layout = (LinearLayout) findViewById(R.id.viewGroup);
        for (int i = 0; i < list.size(); i++) {
            img[i] = new ImageView(MyViewActivity.this);
            if (0 == i) {
                img[i].setBackgroundResource(R.drawable.sel_yes);
            } else {
                img[i].setBackgroundResource(R.drawable.sel_no);
            }
            img[i].setPadding(0, 0, 20, 0);
            layout.addView(img[i]);
        }
        viewpager.setAdapter(new ViewPagerAdapter(list));
        viewpager.setOnPageChangeListener(new ViewPagerPageChangeListener());
    }
 
    class ViewPagerAdapter extends PagerAdapter {
 
        private List<View> list = null;
 
        public ViewPagerAdapter(List<View> list) {
            this.list = list;
        }
 
        @Override
        public int getCount() {
            return list.size();
        }
 
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }
 
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
 
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
 
    }
}
