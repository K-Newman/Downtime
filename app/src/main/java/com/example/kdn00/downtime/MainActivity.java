package com.example.kdn00.downtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity{
    ToggleButton dbR,dbS,dbB,dbI;
    ToggleButton startButton;
    long startTime = 0;
    long duration = 0;
    long runTime = 0;
    String currentActive = "";
    //PrintWriter pw = new PrintWriter(new File("test.csv"));
    StringBuilder sb = new StringBuilder();

    //public MainActivity() throws FileNotFoundException {
    //}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        dbR = findViewById(R.id.dbR);

        TextView textView = (TextView) findViewById(R.id.UpTime);
        textView.setText(runTime+"");

    }
    public void onButtonClick(View view){
        switch(view.getId()){
            case R.id.dbR:
                dbR.setChecked(true);
                dbS.setChecked(false);
                dbB.setChecked(false);
                dbI.setChecked(false);
                //currentActive = "Debagger,Running";

            case R.id.dbS:
                if(dbR.isChecked()){runTime += System.nanoTime() - startTime;}
                dbS.setChecked(true);
                dbR.setChecked(false);
                dbB.setChecked(false);
                dbI.setChecked(false);
                currentActive = "Debagger,Starved";
            case R.id.dbB:
                if(dbR.isChecked()){runTime += System.nanoTime() - startTime;}
                dbB.setChecked(true);
                dbS.setChecked(false);
                dbR.setChecked(false);
                dbI.setChecked(false);
                currentActive = "Debagger,Blocked";
            case R.id.dbI:
                if(dbR.isChecked()){runTime += System.nanoTime() - startTime;}
                dbI.setChecked(true);
                dbS.setChecked(false);
                dbB.setChecked(false);
                dbR.setChecked(false);
                currentActive = "Debagger,Issue";
        }
        //duration = System.nanoTime() - startTime;
        //sb.append(currentActive);
        //sb.append(",");
        //sb.append(duration);
        //startTime = System.nanoTime();
    }

}


