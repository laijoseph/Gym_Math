package com.example.josephmlai.gymmath;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //calculate!
    public void calculate (View view){

        EditText lower = (EditText)findViewById(R.id.lowerWeight);
        EditText upper = (EditText)findViewById(R.id.upperWeight);
        TextView out = (TextView) findViewById(R.id.ans);

        int lowerNum = 45;
        int upperNum = 0;
        String ans;

        if (lower.getText().toString().trim().length() != 0) {//check if lower field is empty
            lowerNum = Integer.parseInt(lower.getText().toString());
        }
        if(upper.getText().toString().trim().length() != 0){//check if higher field is empty
            upperNum = Integer.parseInt(upper.getText().toString());
        }

        if (upperNum < lowerNum){
            out.setTextColor(Color.RED);
            ans = "Invalid upper weight.";
        }else {
            out.setTextColor(Color.BLACK);
            int sum = lowerNum + upperNum;
            ans = Integer.toString(sum);
        }
        out.setText(ans);
    }
}
