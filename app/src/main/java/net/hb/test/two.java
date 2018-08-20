package net.hb.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//새로운 창에 사번, 이름 넘겨서 상세창 보이기
public class two extends Activity implements View.OnClickListener {
    TextView bit;
    TextView tv1,tv2;
    Button btn1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tv1 = findViewById(R.id.tv_sabun);
        tv2 = findViewById(R.id.tv_name);
        btn1 = findViewById(R.id.btn_first);
        btn1.setOnClickListener(this);//새로 추가한 이벤트

        Intent ret = this.getIntent();
        tv1.setText("사번:"+ret.getStringExtra("sabun"));
        tv2.setText("이름:"+ret.getStringExtra("name"));
        bit = new TextView(this);
    }//onCreate end

    @Override
    public void onClick(View vw) {
        int sel=vw.getId();
        if(sel==R.id.btn_first){
            Intent it = new Intent(this,First.class);
            this.startActivity(it);
        }
    }

    public void setMessage(int code, String name){
        bit.setText(code+" "+name);
    }

}//Two class end
