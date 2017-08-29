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

        TextView initLabel = (TextView) findViewById(R.id.startWithLabel);
        TextView addSub = (TextView) findViewById(R.id.addSub);

        TextView fortyFive = (TextView) findViewById(R.id.fortyFive);
        TextView thirtyFive = (TextView) findViewById(R.id.thirtyFive);
        TextView twentyFive = (TextView) findViewById(R.id.twentyFive);
        TextView ten = (TextView) findViewById(R.id.ten);
        TextView five = (TextView) findViewById(R.id.five);
        TextView twoHalf = (TextView) findViewById(R.id.twoHalf);

        TextView diffOut0 = (TextView) findViewById(R.id.diff0);
        TextView diffOut1 = (TextView) findViewById(R.id.diff1);
        TextView diffOut2 = (TextView) findViewById(R.id.diff2);
        TextView diffOut3 = (TextView) findViewById(R.id.diff3);
        TextView diffOut4 = (TextView) findViewById(R.id.diff4);
        TextView diffOut5 = (TextView) findViewById(R.id.diff5);

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
        }else if(lowerNum<45){
            fortyFive.setTextColor(Color.RED);
            fortyFive.setText("Lower weight cannot be less than that of the barbell.");
        }
        else if (lowerNum%5 !=0 || upperNum%5 != 0){//checks if weight is achievable with 45's, 35's, 25's, 10's, 5's, 2.5's
            fortyFive.setTextColor(Color.RED);

            if (lowerNum % 5 != 0 && upperNum % 5 == 0)    ans = "Unachievable lighter weight with increments of 2.5lbs.";
            else if (upperNum % 5 != 0 && lowerNum % 5 == 0)    ans = "Unachievable heavier weight with increments of 2.5lbs.";
            else    ans = "Both lighter and heavier weights are unachievable with increments of 2.5lbs.";
            fortyFive.setText(ans);

        }else{
            initLabel.setText("Starting weights");//top labels
            addSub.setText("+/-");

            fortyFive.setTextColor(thirtyFive.getCurrentTextColor());
            double differencePerSide = (upperNum - lowerNum)/2.0;//works
            //int[] initial = new int[6];
            /*int[] finl = new int[6];
            int[] diff = new int[6];*/

            int[] initial = Arrays.copyOf(initPlates(lowerNum),6);
            int[] finl = Arrays.copyOf(plateDiff(initial,differencePerSide),6);
            int[] diff = Arrays.copyOf(arrDiff(initial, finl), 6);


            String init0 = "45's: "+initial[0];
            String init1 = "35's: "+initial[1];
            String init2 = "25's: "+initial[2];
            String init3 = "10's: "+initial[3];
            String init4 = "5's: "+initial[4];
            String init5 = "2.5's "+initial[5];

            if (diff[0] != 0) {
                String diff0 = "+"+Integer.toString(diff[0]);
                diffOut0.setTextColor(Color.GREEN);//reset color
                if(diff[0] < 0){
                    diffOut0.setTextColor(Color.RED);//if negative, set color to red
                }
                diffOut0.setText(diff0);
            }else {//if it is zero, don't display.
                diffOut0.setText("");
            }

            if (diff[1] != 0) {
                String diff1 = "+"+Integer.toString(diff[1]);
                diffOut1.setTextColor(Color.GREEN);//reset color
                if(diff[1] < 0){
                    diffOut1.setTextColor(Color.RED);//if negative, set color to red
                }
                diffOut1.setText(diff1);
            }else {//if it is zero, don't display.
                diffOut1.setText("");
            }

            if (diff[2] != 0) {
                String diff2 = "+"+Integer.toString(diff[2]);
                diffOut2.setTextColor(Color.GREEN);//reset color
                if(diff[2] < 0){
                    diffOut2.setTextColor(Color.RED);//if negative, set color to red
                }
                diffOut2.setText(diff2);
            }else {//if it is zero, don't display.
                diffOut2.setText("");
            }

            if (diff[3] != 0) {
                String diff3 = "+"+Integer.toString(diff[3]);
                diffOut3.setTextColor(Color.GREEN);//reset color
                if(diff[3] < 0){
                    diffOut3.setTextColor(Color.RED);//if negative, set color to red
                }
                diffOut3.setText(diff3);
            }else {//if it is zero, don't display.
                diffOut3.setText("");
            }

            if (diff[4] != 0) {
                String diff4 = "+"+Integer.toString(diff[4]);
                diffOut4.setTextColor(Color.GREEN);//reset color
                if(diff[4] < 0){
                    diffOut4.setTextColor(Color.RED);//if negative, set color to red
                }
                diffOut4.setText(diff4);
            }else {//if it is zero, don't display.
                diffOut4.setText("");
            }

            if (diff[5] != 0) {
                String diff5 = "+"+Integer.toString(diff[5]);
                diffOut5.setTextColor(Color.GREEN);//reset color
                if(diff[5] < 0){
                    diffOut5.setTextColor(Color.RED);//if negative, set color to red
                }
                diffOut5.setText(diff5);
            }else {//if it is zero, don't display.
                diffOut5.setText("");
            }


            /*String diff1 = Integer.toString(diff[1]);
            diffOut1.setText(diff1);

            String diff2 = Integer.toString(diff[2]);
            diffOut2.setText(diff2);

            String diff3 = Integer.toString(diff[3]);
            diffOut3.setText(diff3);

            String diff4 = Integer.toString(diff[4]);
            diffOut4.setText(diff4);

            String diff5 = Integer.toString(diff[5]);
            diffOut5.setText(diff5);*/

            /*
            String diff0 = Integer.toString(finl[0]);
            String diff1 = Integer.toString(finl[1]);
            String diff2 = Integer.toString(finl[2]);
            String diff3 = Integer.toString(finl[3]);
            String diff4 = Integer.toString(finl[4]);
            String diff5 = Integer.toString(finl[5]);
*/


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
        Double x = Double.valueOf(lower);
        x = (x-45)/2;//x now has weight of each side minus bar

        if (x%5 != 0){
            x = x - 2.5;
            plateCountArr[5]++;
        }//clears any 2.5's.

        x /= 5;//breaking it down into multiplier of 5.

        //THIS WORKS.  TESTED.
        if (x > 17){
            plateCountArr[0] = 2*(x.intValue()/18);//counts number of 45's needed, get the 45's out of the way.
            x %= 18;
        }

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
            case 0:
                break;
        }

        return plateCountArr;
    }//how much the lower weight is


    int[] plateDiff (int[] in, double diff1) {
        int[] plateCountArr = Arrays.copyOf(in, in.length);
        double diff = diff1;
        if (plateCountArr[5] > 0) {//take off non-stackable 2.5's
            diff += 2.5*plateCountArr[5];
            plateCountArr[5] = 0;
        }
        if (plateCountArr[4] < 0){//take off non-stackable 5's
            diff += 5*plateCountArr[4];
            plateCountArr[4]++;
        }
        double factor;//how many of which plates need to be added on.

        if (diff >= 45){
            factor = Math.floor(diff/45);
            plateCountArr[0] += factor;
            diff = diff%45;
        }if (diff >= 35){
            factor = Math.floor(diff/35);
            plateCountArr[1] += factor;
            diff = diff%35;
        }if (diff >= 25){
            factor = Math.floor(diff/25);
            plateCountArr[2] += factor;
            diff = diff%25;
        }if (diff >= 10){
            factor = Math.floor(diff/10);
            plateCountArr[3] += factor;
            diff = diff%10;
        }if (diff >= 5){
            factor = Math.floor(diff/5);
            plateCountArr[4] += factor;
            diff = diff%5;
        }if (diff >= 2.5){
            factor = Math.floor(diff/2.5);
            plateCountArr[5] += factor;
        }return plateCountArr;
    }//first array, then calculates how much more weight needs to be stacked on

    int[] arrDiff(int[] x, int[]y){
        int[] z = Arrays.copyOf(y, y.length);
        for (int i = 0; i < z.length; i++){
            z[i] = z[i]-x[i];
        }
        return z;
    }//returns array with differences between each element at corresponding element set at that index
}
