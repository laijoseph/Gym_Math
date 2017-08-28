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
        TextView fortyFive = (TextView) findViewById(R.id.fortyFive);
        TextView thirtyFive = (TextView) findViewById(R.id.thirtyFive);
        TextView twentyFive = (TextView) findViewById(R.id.twentyFive);
        TextView ten = (TextView) findViewById(R.id.ten);
        TextView five = (TextView) findViewById(R.id.five);
        TextView twoHalf = (TextView) findViewById(R.id.twoHalf);

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
            fortyFive.setTextColor(Color.RED);
            fortyFive.setText("Invalid upper weight.");
        }else if (lowerNum%5 !=0 || upperNum%5 != 0){//checks if weight is achievable with 45's, 35's, 25's, 10's, 5's, 2.5's
            fortyFive.setTextColor(Color.RED);
            if (lowerNum % 5 != 0 && upperNum % 5 == 0)    ans = "Unachievable lighter weight.";
            else if (upperNum % 5 != 0 && lowerNum % 5 == 0)    ans = "Unachievable heavier weight.";
            else    ans = "Both lighter and heavier weights are unachievable.";

    }else{
            fortyFive.setTextColor(Color.BLACK);
            double difference = ((upperNum - lowerNum)-45)/2;
            double[] initial = initPlates((lowerNum-45)/2);
            double[] finl = plateDiff(initial, difference);
            double[] diff = arrDiff(initial, finl);
            String ans45 = "45's: "+initial[0];
            String ans35 = "35's: "+initial[1];
            String ans25 = "25's: "+initial[2];
            String ans10 = "10's: "+initial[3];
            String ans5 = "5's: "+initial[4];
            String ans2half = "2.5's: "+initial[5];

            String diff45 = Double.toString(diff[0]);
            String diff35 = Double.toString(diff[1]);
            String diff25 = Double.toString(diff[2]);
            String diff10 = Double.toString(diff[3]);
            String diff5 = Double.toString(diff[4]);
            String diff2half = Double.toString(diff[5]);

            fortyFive.setText(ans45);
            thirtyFive.setText(ans35);
            twentyFive.setText(ans25);
            ten.setText(ans10);
            five.setText(ans5);
            twoHalf.setText(ans2half);
        }
        //out.setText(ans);
    }

    private double[] initPlates (double z) {//returns string of plates

        double[] plateCountArr = new double[6];//45, 35, 25, 10, 5, 2.5
        Double d = new Double(z);


        if (z%5 != 0){z -= 2.5; plateCountArr[5]++;}
        z = z/5;//multiple of 5

        plateCountArr[0] += z/18;//counts number of 45's needed.

        //plates at 10 or above are stackable/desirable
        switch (d.intValue()%18) {
            //looks up array for largest plate
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
                //plateCountArr[]++;
                break;
        }
        return plateCountArr;
    }
    double[] plateDiff (double[] in, double diff){
        double[] plateCountArr = in;
        if(plateCountArr[5]==1){
            plateCountArr[5]=0;
            diff -= 2.5;
        }
        double factor = 0;
        if (diff > 45){
            factor = diff/45;
            plateCountArr[0] += factor;
            diff = factor%45;
        }if (diff > 35){
            factor = diff/35;
            plateCountArr[1] += factor;
            diff = factor%35;
        }if (diff > 25){
            factor = diff/25;
            plateCountArr[2] += factor;
            diff = factor%25;
        }if (diff > 10){
            factor = diff/10;
            plateCountArr[3] += factor;
            diff = factor%10;
        }if (diff > 5){
            factor = diff/5;
            plateCountArr[4] += factor;
            diff = factor%5;
        }if (diff > 2.5){
            factor = diff/2.5;
            plateCountArr[5] += factor;
            diff = factor%2.5;
        }return plateCountArr;
    }

    double[] arrDiff(double[] x, double[]y){
        for (int i = 0; i < x.length; i++){
            y[i] = y[i]-x[i];
        }
        return y;
    }
}
