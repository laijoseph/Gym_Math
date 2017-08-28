package com.example.josephmlai.gymmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.josephmlai.gymmath.R.id.lowerWeight;
import static com.example.josephmlai.gymmath.R.id.textView3;
import static com.example.josephmlai.gymmath.R.id.upperWeight;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //calculate!
    public void calculate (View view){
        int lower = lowerWeight;
        int upper = upperWeight;
        String out ="";
        TextView textViewOut = (TextView) findViewById(R.id.textView3);

        upper = upper+lower;
        out = Double.toString(upper);
        textViewOut.setText(out);
    }
}
