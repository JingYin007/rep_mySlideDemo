package com.mo.soo.view;

import com.mo.soo.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuRight extends Fragment implements OnClickListener
{
	private View mView;

	private TextView tv_blog,tv_friend;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		if(mView == null)
		{
			mView = inflater.inflate(R.layout.right_menu, container, false);
		}
		return mView ;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
	}
	private void initView() {
		// TODO Auto-generated method stub
		tv_blog=(TextView) getActivity().findViewById(R.id.tv_blog);
		tv_friend=(TextView) getActivity().findViewById(R.id.tv_friend);
		tv_blog.setOnClickListener(this);
		tv_friend.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_blog:
			Intent  i=new Intent(getActivity(), MyViewActivity.class);
			startActivity(i);
			break;
		case R.id.tv_friend:
			Intent  i2=new Intent(getActivity(), Friend.class);
			startActivity(i2);
			break;
		default:
			break;
		}
	}
}
