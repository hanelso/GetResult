package com.example.hanelso.getresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.TextView;

public class CalleeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_callee);

        // Processing...

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data-number",10);
                intent.putExtra("data-string","android");

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

    }
}
