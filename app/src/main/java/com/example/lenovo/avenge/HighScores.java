package com.example.lenovo.avenge;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class HighScores extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        DataBaseHelper myDb = new DataBaseHelper(this);


        Intent in = getIntent();
        String user_name = in.getStringExtra("usr_name");
        String hero_name = in.getStringExtra("hero_name");
        int score = in.getIntExtra("score",0);
        String score_string = Integer.toString(score);



        Boolean result = myDb.insertData(user_name,hero_name,score_string);
        if(result){
            Toast.makeText(this,"SAVED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"SAVED UNSUCCESSFUL",Toast.LENGTH_SHORT).show();
        }

        //TableLayout table = (TableLayout)findViewById(R.id.table);




        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0) {
         /*     TableRow row = new TableRow(this);

            TextView tv1 = new TextView(this);
            tv1.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT,
                    1.0f
            );
            tv1.setLayoutParams(param1);
            tv1.setText(user_name);
            tv1.setTextSize(22f);



            TextView tv2 = new TextView(this);
            tv1.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT,
                    1.0f
            );
            tv1.setLayoutParams(param2);
            tv1.setText(score_string);
            tv1.setTextSize(22f);


            row.addView(tv1);
            row.addView(tv2);
            table.addView(row);*/


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
