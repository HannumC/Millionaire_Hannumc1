package edu.montclair.www.millionaire_hannumc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //display splash screen for 5 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                OpenNewActivity();
            }
        }, 5000); // 5 seconds
    }

    // open Question 1
    public void OpenNewActivity(){
        Intent intent = new Intent(this, Question1.class);
        startActivity(intent);
    }
}
