package com.example.lenovo.avenge;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HighScores2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        DataBaseHelper myDb = new DataBaseHelper(this);
        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0) {


            while (res.moveToNext()){

                stringBuffer.append("NAME: " + res.getString(0) + "\n");
                stringBuffer.append("QUIZ: " + "\"" + res.getString(1)  + "\"" + "\n");
                stringBuffer.append("SCORE: " + res.getString(2) + "\n\n");
            }
            TextView tv = (TextView)findViewById(R.id.result);
            tv.setText(stringBuffer.toString());
        }

    }
}
