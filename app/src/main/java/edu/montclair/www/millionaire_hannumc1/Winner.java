package edu.montclair.www.millionaire_hannumc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        final TextView progressTotal = findViewById(R.id.progressTotal);

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        // get progressTotal from shared preferences
        int earned = sh.getInt("progressTotal", 0);

        // Setting the progress total textView to retrieved data
        progressTotal.setText(String.valueOf(earned));

        final Button btn = findViewById(R.id.tryagain);

        // try again button clicked
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OpenNewActivity();

            }
        });
    }

    // open next question activity
    public void OpenNewActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}