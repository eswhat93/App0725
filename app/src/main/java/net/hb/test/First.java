package net.hb.test;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
//버튼 누르면 바뀌는 그림, 메뉴 생성

public class First extends Activity {

    ImageView iv;
    //Button btn1,btn2,btn3,btn4;
    int count=0;
    int[]picture={R.drawable.oh1,R.drawable.oh2,R.drawable.oh3,
            R.drawable.oh4,R.drawable.oh5,R.drawable.oh6};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        iv=findViewById(R.id.img);//이미지만 가져오기
    }//end

    public void move(View vw){
        int sel = vw.getId();
        if(sel==R.id.btnimage){
            iv.setImageResource(picture[count]);
            count++;
            if(count>5){
                count=0;
                return;
            }
        }else if(sel==R.id.btntwo){
            Intent intent = new Intent(getApplicationContext(),two.class);
            intent.putExtra("sabun","1122");
            Intent.putExtra("name","이은솔");
            startActivity(intent);
        }else if(sel==R.id.btnclose){
            this.finish();
            Toast.makeText(this,"현재문서닫기",Toast.LENGTH_LONG).show();
        }else if(sel==R.id.btnmsg){
            Toast.makeText(this,"이은솔",Toast.LENGTH_LONG).show();
        }else{}
    }//move end
/*View.getContext()
    현재 실행되고 있는 View의 context를 return 하는데 보통은 현재 활성화된 activity의 context가 된다.

  Activity.getApplicationContext()
    어플리케이션의 Context가 return된다. 현재 activiy의 context 뿐만 아니라 application의 lifeCycle에 해당하는 Context가 사용된다.

  ContextWrapper.getBaseContext()
    자신의 Context가 아닌 다른 Context를 access하려 할 때 사용한다. ContextWrapper는 getBaseContext()를 경유해서 Context를 참조할 수 있다.

  this
    View.getContext()와 같다.*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //메뉴생성=>액션바 변경
        MenuItem item1 = menu.add(0,1,0,"image");
        MenuItem item2 = menu.add(0,2,0,"two");
        MenuItem item3 = menu.add(0,3,0,"close");
        MenuItem item4 = menu.add(0,4,0,"msg");
        return true;
    }//end

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //메뉴적용하는 코드
        int sel=item.getItemId();
        if(sel==1) {//그림변경
            iv.setImageResource(picture[count]);
            String temp = String.valueOf(count);
            Log.i("bit",temp+"째 그림");
            count++;
            if(count==6)count=0;
        }else if(sel==2) {//화면이동
            Intent it = new Intent(this,two.class);
            it.putExtra("sabun","7800");
            it.putExtra("name","이은솔");
            Log.i("LG","sabun:7800");
            Log.i("LG","name:이은솔");
            Log.i("KB","09시25분");
            this.startActivity(it);
        }else if(sel==3){//닫기
            this.finish();
        }else if(sel==4){//메세지
            Toast.makeText(this,"메시지",Toast.LENGTH_LONG).show();
        }
        return true;
    }//end
}//First class end
