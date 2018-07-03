package com.example.lenovo.avenge;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Score extends AppCompatActivity {
MediaPlayer strange_circle_sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        final ImageView strange = (ImageView)findViewById(R.id.strange);
        final ImageView score_image = (ImageView)findViewById(R.id.score_circle);
        final TextView score = (TextView)findViewById(R.id.score);
        final TextView SCORE = (TextView)findViewById(R.id.SCORE);


        strange_circle_sound = MediaPlayer.create(Score.this,R.raw.strange_circle_sound_effect);

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(strange, "scaleX", 5.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(strange, "scaleY", 5.0f);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim1, anim2);
        set1.setDuration(500);
// Define second set of animations
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(strange, "X", 100);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(strange, "Y", 100);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(anim3, anim4);
        set2.setDuration(500);
// Play the animation sets one after another
        AnimatorSet set3 = new AnimatorSet();
        set3.playSequentially(set1, set2);
        set3.setDuration(1500);
        set3.start();

                    strange.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            strange_circle_sound.start();
                            ObjectAnimator anim5 = ObjectAnimator.ofFloat(score_image, "scaleX", 40.0f);
                            ObjectAnimator anim6 = ObjectAnimator.ofFloat(score_image, "scaleY", 40.0f);
                            AnimatorSet set4 = new AnimatorSet();
                            set4.playTogether(anim5, anim6);
                            set4.setDuration(4500);
                            set4.start();
                        }
                    }, 1500);

        strange.postDelayed(new Runnable() {

            @Override
            public void run() {
                SCORE.setText("SCORE");
                Intent in = getIntent();
                int final_score = in.getIntExtra("final_score",0);
                score.setText(String.format("%d", final_score));
            }
        }, 5000);


    }

    public void save(View v)
    {
        strange_circle_sound.release();
        EditText user_name = (EditText)findViewById(R.id.user_name);
        Intent getINFO = getIntent();
        int score = getINFO.getIntExtra("final_score",0);
        String hero_name = getINFO.getStringExtra("hero_name");
        Intent in = new Intent(this,HighScores.class);
        in.putExtra("score",score);
        in.putExtra("usr_name",user_name.getText().toString());
        in.putExtra("hero_name",hero_name);
        startActivity(in);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Hero_List.class));
    }
}
