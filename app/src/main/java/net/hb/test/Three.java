package net.hb.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//버튼과 링크 연결
public class Three extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }//end


    // 홈페이지 이동
    public void button1Clicked(View v){
        Uri uri = Uri.parse("http://m.naver.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    // 전화 걸기
    public void button2Clicked(View v){
        Intent it2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-9999-8888"));
        startActivity(it2);
    }

    // 갤러리 열기
    public void button3Clicked(View v){
        Intent it3 = new Intent(Intent.ACTION_GET_CONTENT);
        it3.setType("image/*");
        startActivity(it3);
    }

    // 주소록 이동
    public void button4Clicked(View v) {
        Intent it4 = new Intent();
        it4.setAction(Intent.ACTION_VIEW);
        it4.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivity(it4);
    }

    // 통화목록 이동
    public void button5Clicked(View v){
        Intent showCallLog = new Intent(Intent.ACTION_VIEW);
        showCallLog.setType(CallLog.Calls.CONTENT_TYPE);
        startActivity(showCallLog);
    }


    // 문자 보내기
    public void button6Clicked(View v){
        Intent sendit4 = new Intent(Intent.ACTION_VIEW);
        sendit4.putExtra("sms_body", "so cool~~~~ winter"); // 보낼 문자
        sendit4.putExtra("address", "010-9267-1785"); // 받는사람 번호
        sendit4.setType("vnd.android-dir/mms-sms");//버젼때문에 에러발생
        startActivity(sendit4);
    }

    //First.java문서 이동
    public void button7Clicked(View v) {
        Intent it = new Intent(this, First.class);
        startActivity(it);
    }//end

}//Threee  class END
