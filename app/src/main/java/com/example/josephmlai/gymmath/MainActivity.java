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
            double difference = ((upperNum - lowerNum)-45)/2;
            double[] initial = initPlates((lowerNum-45)/2);
            double[] finl = plateDiff(initial, difference);
            //ans = Integer.toString(difference);
        }
        out.setText(ans);
    }

    private double[] initPlates (double x) {//returns string of plates

        double[] plateCountArr = new double[6];//45, 35, 25, 10, 5, 2.5


        if (z%5 != 0){z -= 2.5; plateCountArr[5]++;}
        z = z/5;//multiple of 5

        plateCountArr[0] += z/18;//counts number of 45's needed.

        //plates at 10 or above are stackable/desirable
        switch (z%18) {
            ;//looks up array for largest plate
            case 17:
                plateCountArr[1]++;
                plateCountArr[2]+=2;
                break;
            case 16:
                plateCountArr[0]++;
                plateCountArr[1]++;
                break;
            case 15:
                plateCountArr[2]+=3;
                break;
            case 14:
                plateCountArr[0]++;
                plateCountArr[2]++;
                break;
            case 13:
                plateCountArr[0]++;
                plateCountArr[3]+=2;
                break;
            case 12:
                plateCountArr[1]++;
                plateCountArr[2]++;
                break;
            case 11:
                plateCountArr[0]++;
                plateCountArr[3]++;
                break;
            case 10:
                plateCountArr[2]+=2;
                break;
            case 9:
                plateCountArr[0]++;
                break;
            case 8:
                plateCountArr[1]++;
                plateCountArr[4]++;
                break;
            case 7:
                plateCountArr[1]++;
                break;
            case 6:
                plateCountArr[2]++;
                plateCountArr[4]++;
                break;
            case 5:
                plateCountArr[2]++;
                break;
            case 4:
                plateCountArr[3]+=2;
                break;
            case 3:
                plateCountArr[3]++;
                plateCountArr[4]++;
                break;
            case 2:
                plateCountArr[3]++;
                break;
            case 1:
                plateCountArr[4]++;
                break;
            case 0:
                plateCountArr[]++;
                break;
        }
        return plateCountArr;
    }
    double[] finl (double[] in, double diff){
        double[] plateCountArr = in;


        return plateCountArr;
    }
}