package com.example.hanelso.getresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CallerActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_CALLEEACTIVITY = 1;
    private static final int REQUEST_CODE_DIALOGACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_caller);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CallerActivity.this,CalleeActivity.class);

                // activity에 requestcode를 줌으로서 표식을 남기는 것이다.!!!!!!
                startActivityForResult(intent,REQUEST_CODE_CALLEEACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch(requestCode)
        {
            case REQUEST_CODE_CALLEEACTIVITY:
            {
                if(resultCode == Activity.RESULT_OK){
                    int dataNumber =  intent.getIntExtra("data-number",-1);
                    String dataString = intent.getStringExtra("data-string");

                    String data = "data-number: " + dataNumber + "\ndata-string: " + dataString;
                    // layout에서 id값으로 객체를 받아온다.
                    // setText라는 메소드를 이용하기 위해서는 TextView(View의 자식클래스) 클래스가 필요하다!
                    TextView textView = findViewById(R.id.textView3);
                    textView.setText(data);
                } else{
                    Log.d("MainActivity","Result Canceled");
                }
                break;

            }

            case REQUEST_CODE_DIALOGACTIVITY:
            {
                break;
            }

            default:
            {
                break;
            }
        }
    }
}
