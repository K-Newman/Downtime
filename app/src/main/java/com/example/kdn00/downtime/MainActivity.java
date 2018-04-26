package com.example.kdn00.downtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity{
    ToggleButton dbR,dbS,dbB,dbI;
    ToggleButton bfR,bfS,bfB,bfI;
    ToggleButton fR,fS,fB,fI;
    ToggleButton cpR,cpS,cpB,cpI;
    ToggleButton pR,pS,pB,pI;
    Button completeButton;
    long dbTime,bfTime,fTime,cpTime,pTime = 0;
    double dbDuration,bfDuration,fDuration,cpDuration,pDuration = 0;
    String dbActive,bfActive,fActive,cpActive,pActive = "";
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

        bfR = findViewById(R.id.bfR);
        bfB = findViewById(R.id.bfB);
        bfS = findViewById(R.id.bfS);
        bfI = findViewById(R.id.bfI);

        fR = findViewById(R.id.fR);
        fB = findViewById(R.id.fB);
        fS = findViewById(R.id.fS);
        fI = findViewById(R.id.fI);

        cpR = findViewById(R.id.cpR);
        cpB = findViewById(R.id.cpB);
        cpS = findViewById(R.id.cpS);
        cpI = findViewById(R.id.cpI);

        pR = findViewById(R.id.pR);
        pB = findViewById(R.id.pB);
        pS = findViewById(R.id.pS);
        pI = findViewById(R.id.pI);

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
                dbDuration = (System.nanoTime() - dbTime)/1000000000.0;
                sb.append(dbDuration +"");
                sb.append("\n");
                dbTime = System.nanoTime();
                dbActive = "Running";
            }
        });

        dbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                dbDuration = (System.nanoTime() - dbTime)/1000000000.0;
                sb.append(dbDuration +"");
                sb.append("\n");
                dbTime = System.nanoTime();
                dbActive = "Blocked";
            }
        });

        dbS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                dbDuration = (System.nanoTime() - dbTime)/1000000000.0;
                sb.append(dbDuration +"");
                sb.append("\n");
                dbTime = System.nanoTime();
                dbActive = "Starved";
            }
        });

        dbI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                dbDuration = (System.nanoTime() - dbTime)/1000000000.0;
                sb.append(dbDuration +"");
                sb.append("\n");
                dbTime = System.nanoTime();
                dbActive = "Issue";
            }
        });

        bfR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bfI.setChecked(false);
                bfB.setChecked(false);
                bfS.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("BoxFormer,");
                sb.append(name);
                sb.append(",");
                sb.append(bfActive);
                sb.append(",");
                bfDuration = (System.nanoTime() - bfTime)/1000000000.0;
                sb.append(bfDuration + "");
                sb.append("\n");
                bfTime = System.nanoTime();
                bfActive = "Running";
            }
        });

        bfB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bfI.setChecked(false);
                bfR.setChecked(false);
                bfS.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("BoxFormer,");
                sb.append(name);
                sb.append(",");
                sb.append(bfActive);
                sb.append(",");
                bfDuration = (System.nanoTime() - bfTime)/1000000000.0;
                sb.append(bfDuration + "");
                sb.append("\n");
                bfTime = System.nanoTime();
                bfActive = "Blocked";
            }
        });

        bfI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bfR.setChecked(false);
                bfB.setChecked(false);
                bfS.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("BoxFormer,");
                sb.append(name);
                sb.append(",");
                sb.append(bfActive);
                sb.append(",");
                bfDuration = (System.nanoTime() - bfTime)/1000000000.0;
                sb.append(bfDuration + "");
                sb.append("\n");
                bfTime = System.nanoTime();
                bfActive = "Issue";
            }
        });

        bfS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bfI.setChecked(false);
                bfB.setChecked(false);
                bfR.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("BoxFormer,");
                sb.append(name);
                sb.append(",");
                sb.append(bfActive);
                sb.append(",");
                bfDuration = (System.nanoTime() - bfTime)/1000000000.0;
                sb.append(bfDuration + "");
                sb.append("\n");
                bfTime = System.nanoTime();
                bfActive = "Starved";
            }
        });

        fR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fI.setChecked(false);
                fB.setChecked(false);
                fS.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("Filler,");
                sb.append(name);
                sb.append(",");
                sb.append(fActive);
                sb.append(",");
                fDuration = (System.nanoTime() - fTime)/1000000000.0;
                sb.append(fDuration + "");
                sb.append("\n");
                fTime = System.nanoTime();
                fActive = "Running";
            }
        });

        fI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fR.setChecked(false);
                fB.setChecked(false);
                fS.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("Filler,");
                sb.append(name);
                sb.append(",");
                sb.append(fActive);
                sb.append(",");
                fDuration = (System.nanoTime() - fTime)/1000000000.0;
                sb.append(fDuration + "");
                sb.append("\n");
                fTime = System.nanoTime();
                fActive = "Issue";
            }
        });

        fB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fI.setChecked(false);
                fR.setChecked(false);
                fS.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("Filler,");
                sb.append(name);
                sb.append(",");
                sb.append(fActive);
                sb.append(",");
                fDuration = (System.nanoTime() - fTime)/1000000000.0;
                sb.append(fDuration + "");
                sb.append("\n");
                fTime = System.nanoTime();
                fActive = "Blocked";
            }
        });

        fS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fI.setChecked(false);
                fB.setChecked(false);
                fR.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("Filler,");
                sb.append(name);
                sb.append(",");
                sb.append(fActive);
                sb.append(",");
                fDuration = (System.nanoTime() - fTime)/1000000000.0;
                sb.append(fDuration + "");
                sb.append("\n");
                fTime = System.nanoTime();
                fActive = "Starved";
            }
        });

        cpR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpS.setChecked(false);
                cpI.setChecked(false);
                cpB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("CasePacker,");
                sb.append(name);
                sb.append(",");
                sb.append(cpActive);
                sb.append(",");
                cpDuration = (System.nanoTime() - cpTime)/1000000000.0;
                sb.append(cpDuration +"");
                sb.append("\n");
                cpTime = System.nanoTime();
                cpActive = "Running";
            }
        });

        cpS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpR.setChecked(false);
                cpI.setChecked(false);
                cpB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("CasePacker,");
                sb.append(name);
                sb.append(",");
                sb.append(cpActive);
                sb.append(",");
                cpDuration = (System.nanoTime() - cpTime)/1000000000.0;
                sb.append(cpDuration +"");
                sb.append("\n");
                cpTime = System.nanoTime();
                cpActive = "Starved";
            }
        });

        cpI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpS.setChecked(false);
                cpR.setChecked(false);
                cpB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("CasePacker,");
                sb.append(name);
                sb.append(",");
                sb.append(cpActive);
                sb.append(",");
                cpDuration = (System.nanoTime() - cpTime)/1000000000.0;
                sb.append(cpDuration +"");
                sb.append("\n");
                cpTime = System.nanoTime();
                cpActive = "Issue";
            }
        });

        cpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpS.setChecked(false);
                cpI.setChecked(false);
                cpR.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("CasePacker,");
                sb.append(name);
                sb.append(",");
                sb.append(cpActive);
                sb.append(",");
                cpDuration = (System.nanoTime() - cpTime)/1000000000.0;
                sb.append(cpDuration +"");
                sb.append("\n");
                cpTime = System.nanoTime();
                cpActive = "Blocked";
            }
        });

        pR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pS.setChecked(false);
                pI.setChecked(false);
                pB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("Palletizer,");
                sb.append(name);
                sb.append(",");
                sb.append(pActive);
                sb.append(",");
                pDuration = (System.nanoTime() - pTime)/1000000000.0;
                sb.append(pDuration +"");
                sb.append("\n");
                pTime = System.nanoTime();
                pActive = "Running";


            }
        });

        pS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pR.setChecked(false);
                pI.setChecked(false);
                pB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("Palletizer,");
                sb.append(name);
                sb.append(",");
                sb.append(pActive);
                sb.append(",");
                pDuration = (System.nanoTime() - pTime)/1000000000.0;
                sb.append(pDuration +"");
                sb.append("\n");
                pTime = System.nanoTime();
                pActive = "Starved";
            }
        });

        pI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pS.setChecked(false);
                pR.setChecked(false);
                pB.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("Palletizer,");
                sb.append(name);
                sb.append(",");
                sb.append(pActive);
                sb.append(",");
                pDuration = (System.nanoTime() - pTime)/1000000000.0;
                sb.append(pDuration +"");
                sb.append("\n");
                pTime = System.nanoTime();
                pActive = "Issue";
            }
        });

        pB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pS.setChecked(false);
                pI.setChecked(false);
                pR.setChecked(false);
                now = new Date();
                name = new SimpleDateFormat("HHmmss").format(now);
                sb.append("Palletizer,");
                sb.append(name);
                sb.append(",");
                sb.append(pActive);
                sb.append(",");
                pDuration = (System.nanoTime() - pTime)/1000000000.0;
                sb.append(pDuration +"");
                sb.append("\n");
                pTime = System.nanoTime();
                pActive = "Blocked";
            }
        });
    }

}


