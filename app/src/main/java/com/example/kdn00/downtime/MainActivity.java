package com.example.kdn00.downtime;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity{
    ToggleButton dbR,dbS,dbB,dbI;
    ToggleButton startButton;
    TextView textView;
    EditText testOutput;
    long startTime = 0;
    long duration = 0;
    long runTime;
    String dbActive = "";
    StringBuilder sb = new StringBuilder();
    Date now = new Date();


    String name = new SimpleDateFormat("HHmmss").format(now);
    FileWriter output;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        dbR = findViewById(R.id.dbR);
        dbB = findViewById(R.id.dbB);
        dbS = findViewById(R.id.dbS);
        dbI = findViewById(R.id.dbI);


        textView = findViewById(R.id.UpTime);
        testOutput = findViewById(R.id.testOutput);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        dbR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbS.setChecked(false);
                dbI.setChecked(false);
                dbB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append(name);
                sb.append(dbActive);
                sb.append(",");
                sb.append((System.nanoTime() - startTime)/1000000000.0);
                sb.append("\n");
                testOutput.setText(sb);
                startTime = System.nanoTime();
                dbActive = "Running";
                try {
                    output = new FileWriter("test.csv");
                    output.write(sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        dbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbR.isChecked()){
                    runTime += System.nanoTime() - startTime;
                    textView.setText(runTime/1000000000.0 + "");
                }
                dbR.setChecked(false);
                dbI.setChecked(false);
                dbS.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append(name);
                sb.append(dbActive);
                sb.append(",");
                sb.append((System.nanoTime() - startTime)/1000000000.0);
                sb.append("\n");
                testOutput.setText(sb);
                startTime = System.nanoTime();
                dbActive = "Blocked";
            }
        });

        dbS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbR.isChecked()){
                    runTime += System.nanoTime() - startTime;
                    textView.setText(runTime/1000000000.0 + "");
                }
                dbR.setChecked(false);
                dbI.setChecked(false);
                dbB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append(name);
                sb.append(dbActive);
                sb.append(",");
                sb.append((System.nanoTime() - startTime)/1000000000.0);
                sb.append("\n");
                testOutput.setText(sb);
                startTime = System.nanoTime();
                dbActive = "Starved";
            }
        });

        dbI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbR.isChecked()){
                    runTime += System.nanoTime() - startTime;
                    textView.setText(runTime/1000000000.0 + "");
                }
                dbR.setChecked(false);
                dbS.setChecked(false);
                dbB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append(name);
                sb.append(dbActive);
                sb.append(",");
                sb.append((System.nanoTime() - startTime)/1000000000.0);
                sb.append("\n");
                testOutput.setText(sb);
                startTime = System.nanoTime();
                dbActive = "Issue";

            }
        });

    }

}


