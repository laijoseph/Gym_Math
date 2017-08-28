package com.example.josephmlai.gymmath;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

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
            double differencePerSide = (upperNum - lowerNum)/2.0;//works
            int[] initial = new int[6];
            int[] finl = new int[6];
            int[] diff = new int[6];

            System.arraycopy(initPlates(lowerNum), 0, initial,0, 6);
            System.arraycopy(plateDiff(initial, differencePerSide), 0, finl,0, 6);
            System.arraycopy(arrDiff(initial, finl), 0, diff,0, 6);

            String init0 = "45's: "+initPlates(lowerNum)[0];
            String init1 = "35's: "+initial[1];
            String init2 = "25's: "+initial[2];
            String init3 = "10's: "+initial[3];
            String init4 = "5's: "+initial[4];
            String init5 = "2.5's: "+initPlates(lowerNum)[5]+" Difference per side: "+differencePerSide+"Lower num: "+ lowerNum+ " inital arr length "+initial.length;

            String diff0 = Double.toString(diff[0]);
            String diff1 = Double.toString(diff[1]);
            String diff2 = Double.toString(diff[2]);
            String diff3 = Double.toString(diff[3]);
            String diff4 = Double.toString(diff[4]);
            String diff5 = Double.toString(diff[5]);

            fortyFive.setText(init0);
            thirtyFive.setText(init1);
            twentyFive.setText(init2);
            ten.setText(init3);
            five.setText(init4);
            twoHalf.setText(init5);
        }
    }

    private int[] initPlates (int lower) {//returns arr of plates

        int[] plateCountArr = new int[6];//45, 35, 25, 10, 5, 2.5
        Double x = new Double(lower);
        x = (x-45)/2;//x now has weight of each side minus bar

        /*if (x%5 != 0){
            x = x - 2.5;
            plateCountArr[5]++;
        }*///clears any 2.5's.

        x = x/5;//breaking it down into multiplier of 5.

        //THIS WORKS.  TESTED.
        if (x > 17){
            plateCountArr[0] = (x.intValue()/9);//counts number of 45's needed, get the 45's out of the way.
            x = x%18;
        }
/*
        //plates at 10 or above are stackable && preferred
        switch (x.intValue()) {
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
            case 0://do nothing, already taken care of
                break;
        }*/

        return plateCountArr;
    }


    int[] plateDiff (int[] in, double diff){
        int[] plateCountArr = in;
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

    int[] arrDiff(int[] x, int[]y){
        for (int i = 0; i < x.length; i++){
            y[i] = y[i]-x[i];
        }
        return y;
    }
}
