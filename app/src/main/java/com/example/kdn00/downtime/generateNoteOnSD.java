package com.example.kdn00.downtime;

import android.Manifest;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class generateNoteOnSD {

    public void generateNoteOnSD(String body){
        String fileName = "DowntimeData.txt";

        try
            {
            File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator,"Notes");
            if (!root.exists()){
                root.mkdir();

            }
            File theData = new File(root,fileName);
            FileWriter writer = new FileWriter(theData,true);

            writer.append(body+"\n");
            writer.flush();
            writer.close();
            //Toast.makeText(this,"Success",Toast.LENGTH_SHORT);
            }
        catch(IOException e)
        {
            Log.e("MYAPP","exception",e);
            //e.printStackTrace();
        }
    }
}
