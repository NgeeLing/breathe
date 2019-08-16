package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        textView = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);

        Integer result= intent.getExtras().getInt("result");

        if(result <= 20){
            textView.setText("Low");
            textView2.setText("It seems like you have less stress life. Keep it up. Don't be stress");
        }else if(result <=30){
            textView.setText("Moderate");
            textView2.setText("It seems like you have a little bit stress. We recommend you listening the relax music to reduce your stress");
        }else{
            textView.setText("High");
            textView2.setText("It seems like you have more stress. We recommend you to take the breathing and listening the relax music to reduce your stress");
        }
    }

    public void back(View view) {
        finish();
        //moveTaskToBack(true);
    }
}
