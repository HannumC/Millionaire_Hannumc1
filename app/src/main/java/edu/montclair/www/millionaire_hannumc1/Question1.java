package edu.montclair.www.millionaire_hannumc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        final Button SubButton = findViewById(R.id.submit);

        // submit button clicked
        SubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get radio group and check if the answer is correct
                RadioGroup radGroup = findViewById(R.id.Q1);
                if(isCorrect(1, radGroup) == 1 ){

                    // display toast
                    String toastDisp = getResources().getString(R.string.Correct);
                    toastDisp = toastDisp + "100!";
                    Toast.makeText(getApplicationContext(), toastDisp, Toast.LENGTH_LONG).show();

                    final TextView progressTotal = findViewById(R.id.progressTotal);
                    int earned = Integer.parseInt(progressTotal.getText().toString());

                    // increment the total earned by 100
                    earned = earned + 100;
                    String newProg = Integer.toString(earned);

                    // set progress total to new amount
                    progressTotal.setText(newProg);

                    // save newProg in shared preferences to retrieve in next activity
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putInt("progressTotal", Integer.parseInt(progressTotal.getText().toString()));

                    myEdit.apply();

                    Handler handler = new Handler();

                    // wait 2 second
                    handler.postDelayed(new Runnable() { public void run() {OpenNewActivity(); }}, 2000); // 2 seconds

                }else{
                    // display toast
                    String toastDisp = getResources().getString(R.string.Incorrect);
                    Toast.makeText(getApplicationContext(), toastDisp, Toast.LENGTH_LONG).show();

                    final TextView progressTotal = findViewById(R.id.progressTotal);

                    // save newProg in shared preferences to retrieve in next activity
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putInt("progressTotal", Integer.parseInt(progressTotal.getText().toString()));

                    myEdit.apply();

                    Handler handler = new Handler();

                    // wait 2 second
                    handler.postDelayed(new Runnable() { public void run() {OpenLostGame(); }}, 2000); // 2 seconds
                }
            }
        });
    }

    // check if the answer is correct
    // return 1 if correct, 0 if incorrect
    public int isCorrect(int correctChoice, RadioGroup ID){
        int radioButtonID = ID.getCheckedRadioButtonId();
        View radioButton = ID.findViewById(radioButtonID);
        int index = ID.indexOfChild(radioButton);

        if(index == correctChoice){
            return 1;
        }else{
            return 0;
        }
    }

    // open next question activity
    public void OpenNewActivity(){
        Intent intent = new Intent(this, Question2.class);
        startActivity(intent);
    }

    // open lost game activity
    public void OpenLostGame(){
        Intent intent = new Intent(this, LostGame.class);
        startActivity(intent);
    }
}

