package com.example.rockf.a7activity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    TextView text;
    final static int ACT1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
    }

    public void buttonClick(View v) {
        Intent intent;
        Uri uri;

        switch (v.getId()) {
            case R.id.bt1:
                //명시적 인텐트 이용. SubActivity.class는 Manifest에 등록을 시켜야 한다!
                intent = new Intent(this, SubActivity.class);
                startActivity(intent);  //액티비티 호출 메서드
                break;

            case R.id.bt2:
                //값 전달하는 인텐트
                intent = new Intent(this, SubActivity.class);
                intent.putExtra("param", "보내는 문자열");    //전달할 값
                startActivityForResult(intent, ACT1);       //값을 주고받을 액티비티 호출시 사용 메서드
                break;

            //암시적 인텐트
            case R.id.bt3:
                //웹 브라우저 호출
                uri = Uri.parse("http://www.nate.com/");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.bt4:
                //전화걸기
                uri = Uri.parse("tel:010-1111-1111");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;

            case R.id.bt5 :
                //이메일 보내기. 에뮬레이터에서는 동작하지 않음
                uri = Uri.parse("mailto:shoonara21@gmail.com");
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
                break;

            case R.id.bt6 :
                //구글 맵 띄우기
                uri = Uri.parse("geo:38.899533, -77.036476");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.bt7 :
                //구글 길찾기 띄우기
                uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=코엑스&daddr=강남역&hl=ko");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.bt8 :
                // SMS 발송
                uri = Uri.parse("smsto:011-1111-1111");
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "문자 내용");
                startActivity(intent);
                break;

            case R.id.bt9 :
                //구글 검색
                intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"롤리팝");
                startActivity(intent);
                break;
        }
    }

    //startActivityForResult()로 호출한 액티비티로부터 값을 되돌려 받음
    //(호출시 지정한 번호, 실행결과, 리턴된 값)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ACT1 :
                if (resultCode == RESULT_OK) {
                    String s = data.getStringExtra("returnData");
                    text.setText("서브 액티비티에서 보낸 값은 : " + s);
                }
        }
    }

}
