package com.mo.soo.view;


import com.mo.soo.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends Activity{
	AnimationDrawable ad;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		final Window window = getWindow();// ��ȡ��ǰ�Ĵ������
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);// ������״̬��
		requestWindowFeature(Window.FEATURE_NO_TITLE);// �����˱�����
		setContentView(R.layout.welcome_view);
		ImageView imageView = (ImageView) findViewById(R.id.iv_toMain);// ���ҵ���Ӧ��ImageView
		imageView.setImageResource(R.drawable.wa);// ע��drawable�е�ͼƬ��name������Сд��ĸ
		Animation a=AnimationUtils.loadAnimation(this,R.anim.ha);
		imageView.startAnimation(a);
		a.setFillAfter(true);
		welcomeUI();
	}

	private void welcomeUI()
	{
		new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					Thread.sleep(3000);
					Message message = new Message();
					welHandler.sendMessage(message);// ������Ϣ�а���ʲô����������Ҫ����Ϊ���յĺ�������Ҫ�ò���
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}

	Handler welHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg)
		{
			welcomeFunction();
		}

	};

	public void welcomeFunction()
	{
		Intent intent = new Intent();
		intent.setClass(WelcomeActivity.this, MainActivity.class);
		startActivity(intent);
		WelcomeActivity.this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
