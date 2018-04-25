package com.example.kdn00.downtime;

import android.Manifest;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity{
    ToggleButton dbR,dbS,dbB,dbI;
    Button completeButton;
    TextView textView;
    long startTime = 0;
    double duration = 0;
    long runTime;
    String dbActive = "";
    StringBuilder sb = new StringBuilder();
    Date now = new Date();
    generateNoteOnSD body = new generateNoteOnSD();

    String name = new SimpleDateFormat("HHmmss").format(now);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        completeButton = findViewById(R.id.completeButton);
        dbR = findViewById(R.id.dbR);
        dbB = findViewById(R.id.dbB);
        dbS = findViewById(R.id.dbS);
        dbI = findViewById(R.id.dbI);


        textView = findViewById(R.id.UpTime);


        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                body.generateNoteOnSD(sb.toString());
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
                sb.append("Debagger,");
                sb.append(name);
                sb.append(",");
                sb.append(dbActive);
                sb.append(",");
                duration = (System.nanoTime() - startTime)/1000000000.0;
                sb.append(duration+"");
                sb.append("\n");
                startTime = System.nanoTime();
                dbActive = "Running";


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
                sb.append("Debagger,");
                sb.append(name);
                sb.append(",");
                sb.append(dbActive);
                sb.append(",");
                duration = (System.nanoTime() - startTime)/1000000000.0;
                sb.append(duration+"");
                sb.append("\n");
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
                sb.append("Debagger,");
                sb.append(name);
                sb.append(",");
                sb.append(dbActive);
                sb.append(",");
                duration = (System.nanoTime() - startTime)/1000000000.0;
                sb.append(duration+"");
                sb.append("\n");
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
                sb.append("Debagger,");
                sb.append(name);
                sb.append(",");
                sb.append(dbActive);
                sb.append(",");
                duration = (System.nanoTime() - startTime)/1000000000.0;
                sb.append(duration+"");
                sb.append("\n");
                startTime = System.nanoTime();
                dbActive = "Issue";

            }
        });

    }

}


