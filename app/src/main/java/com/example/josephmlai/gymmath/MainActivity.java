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
    public void calculate (View view) {

        EditText lower = (EditText) findViewById(R.id.lowerWeight);
        EditText upper = (EditText) findViewById(R.id.upperWeight);
        TextView out = (TextView) findViewById(R.id.ans);

        int lowerNum = 45;
        int upperNum = 0;
        String ans;

        if (lower.getText().toString().trim().length() != 0) {//check if lower field is empty
            lowerNum = Integer.parseInt(lower.getText().toString());
        }
        if (upper.getText().toString().trim().length() != 0) {//check if higher field is empty
            upperNum = Integer.parseInt(upper.getText().toString());
        }

        if (upperNum < lowerNum) {//catches if higher weight is null or is less than lower weight.
            out.setTextColor(Color.RED);
            ans = "Invalid upper weight.";
        }else if (lowerNum%5 !=0 || upperNum%5 != 0){//checks if weight is achievable with 45's, 35's, 25's, 10's, 5's, 2.5's
            out.setTextColor(Color.RED);
            if (lowerNum % 5 != 0 && upperNum % 5 == 0)    ans = "Unachievable lighter weight.";
            else if (upperNum % 5 != 0 && lowerNum % 5 == 0)    ans = "Unachievable heavier weight.";
            else    ans = "Both lighter and heavier weights are unachievable.";

    }else{
            out.setTextColor(Color.BLACK);
            int difference = ((upperNum - lowerNum)-45)/2;
            findPlates();
            ans = Integer.toString(difference);
        }
        out.setText(ans);
    }

    private String findPlates(){//returns string of plates

        return null;
    }
}
