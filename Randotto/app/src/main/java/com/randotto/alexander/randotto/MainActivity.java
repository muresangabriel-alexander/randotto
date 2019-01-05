package com.randotto.alexander.randotto;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static int randotto() {
        Random rand = new Random();

        int n = rand.nextInt(777);
        return (n % 49 + 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getNumbers(View view) {
        int [] E6_nums = new int[12];

        for (int i=0; i<6; ++i){
            E6_nums[i]=randotto();
        }

        Arrays.sort(E6_nums,0,6);
        boolean uni = false;
        while (!uni){
            uni = true;
            for(int i= 0; i<5; ++i){
                if(E6_nums[i]==E6_nums[i+1]){
                    E6_nums[i]=randotto();
                    Arrays.sort(E6_nums,0,6);
                    uni = false;
                    break;
                }
            }
        }

        TextView firstN = (TextView)findViewById(R.id.textView);
        TextView secondN = (TextView)findViewById(R.id.textView5);
        TextView thirdN = (TextView)findViewById(R.id.textView2);
        TextView fourthN = (TextView)findViewById(R.id.textView9);
        TextView fifthN = (TextView)findViewById(R.id.textView8);
        TextView sixthN = (TextView)findViewById(R.id.textView3);

        firstN.setText(Integer.toString(E6_nums[0]));
        secondN.setText(Integer.toString(E6_nums[1]));
        thirdN.setText(Integer.toString(E6_nums[2]));
        fourthN.setText(Integer.toString(E6_nums[3]));
        fifthN.setText(Integer.toString(E6_nums[4]));
        sixthN.setText(Integer.toString(E6_nums[5]));
    }
}
