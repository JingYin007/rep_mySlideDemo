package com.mo.soo.view;

import com.mo.soo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab02 extends Fragment
{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View messageLayout = inflater.inflate(R.layout.main_tab_02, container, false);
		return messageLayout;
	}

}
