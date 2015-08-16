package com.mo.soo.util;


import com.mo.soo.R;
import com.mo.soo.view.MyViewActivity;

import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ViewPagerPageChangeListener implements OnPageChangeListener{
    /*
     * state������ͨ��˵����1��ʱ���ʾ���ڻ�����2��ʱ���ʾ��������ˣ�0��ʱ���ʾʲô��û��������ͣ���ǣ�
     * �ҵ���Ϊ��1�ǰ���ʱ��0���ɿ���2�����µı�ǩҳ���Ƿ񻬶���
     * (���磺��ǰҳ�ǵ�һҳ����������һ������ӡ��2���������ֱ�������˵ڶ�ҳ����ô�ͻ��ӡ��2��)��
     * ������Ϊһ��������ǲ�����д���������
     */
    @Override
    public void onPageScrollStateChanged(int state) {
    }

    /*
     * page�������ƾͿ��ó�����ǰҳ�� positionOffset��λ��ƫ��������Χ[0,1]��
     * positionoffsetPixels��λ�����أ���Χ[0,��Ļ���)�� ������Ϊһ��������ǲ�����д���������
     */
    @Override
    public void onPageScrolled(int page, float positionOffset,
            int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int page) {
        //����ͼ��
        for (int i = 0; i < MyViewActivity.list.size(); i++) {
            if (page == i) {
            	MyViewActivity. img[i].setBackgroundResource(R.drawable.sel_yes);
            } else {
            	MyViewActivity.img[i].setBackgroundResource(R.drawable.sel_no);
            }
        }
    }
}
