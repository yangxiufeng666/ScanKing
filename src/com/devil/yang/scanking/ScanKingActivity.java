package com.devil.yang.scanking;

import org.madmatrix.zxing.android.CaptureActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.devil.yang.scanking.util.UnZipUtil;
import com.umeng.analytics.MobclickAgent;

public class ScanKingActivity extends FragmentActivity{
	private Button orcButton;
	private Button decodeButton;
	private Handler mHandler;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.scanking_main_layout);
		orcButton = (Button)findViewById(R.id.orc_btn);
		decodeButton = (Button)findViewById(R.id.decode_btn);
		orcButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				go2Orc();
			}
		});
		decodeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				go2Capture();
			}
		});
		mHandler = new Handler();
		mHandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				boolean flag = UnZipUtil.unzipFile(ScanKingActivity.this);
				Log.e("Unzip", "flag = "+ flag);
			}
		}, 2000);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		MobclickAgent.onResume(this);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPause(this);
	}
	private void go2Orc(){
		Intent intent = new Intent();
		intent.setClass(this, OCRActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.fade, R.anim.hold);
	}
	private void go2Capture(){
		Intent intent = new Intent();
		intent.setClass(this, CaptureActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.fade, R.anim.hold);
	}
}
