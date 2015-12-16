package com.example.rockf.a7activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends Activity {
	TextView text;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		text = (TextView) findViewById(R.id.subText);
		
		//메인 액티비티로부터 전달받은 데이터
		Intent intent = getIntent();
		String s = intent.getStringExtra("param");
		if (s != null) {
			text.setText("메인 액티비티로부터 전달된 값 : " + s);
		}
	}
	
	public void buttonClick(View view) {
		//메인 액티비티로 되돌려줄 값
		Intent intent = new Intent();
		intent.putExtra("returnData", "서브 액티비티에서 보냄");
		setResult(RESULT_OK, intent);
		
		finish();		//액티비티 종료
	}
}
