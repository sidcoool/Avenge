package com.example.lenovo.avenge;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class Quiz extends AppCompatActivity {
        /*ObjectAnimator moveAnim = ObjectAnimator.ofFloat(heart, "X", 500);
         ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(heart, "rotation", 0.5f);
            fadeAnim.start();

        moveAnim.setDuration(6000);
        moveAnim.setInterpolator(new BounceInterpolator());
        moveAnim.start();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(heart, "scaleX", 2.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(heart, "scaleY", 2.0f);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim1, anim2);
// Define second set of animations
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(test, "X", 300);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(test, "Y", 300);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(anim3, anim4);
// Play the animation sets one after another
        AnimatorSet set3 = new AnimatorSet();
        set3.playSequentially(set1, set2);
        set3.start();*/

    int counter1=2,counter2=0;
    boolean encounter=true;
    MediaPlayer instructions_voice_mp3;
     String question2, question3, question4,question5, option21, option22, option23, option24, option31, option32, option33, option34, option41, option42, option43, option44,option51,option52,option53,option54;
     TextView captain_quiz;
     ImageView hero_img;
     RadioButton option1;
     RadioButton option2;
     RadioButton option3;
     RadioButton option4;
     RadioGroup radioGroup;

    private void  ques_and_ans() {

        question2 = "What is Cap's shield made from?";
        question3 = "In Marvels Civil War Storyline, Steve Rogers fought for what?";
        question4 = "This Pic is from which Marvel movie?";
        question5 = "What group of superheroes did Captain America team up with before the Avengers?";
        option21 = "Vibranium";
        option22 = "Titanium";
        option23 = "Iron";
        option24 = "Adamantium";
        option31 = "Unifying of heroes under one advanced military unit";
        option32 = "The US Govenment's registration of masked heroes identities";
        option33 = "The freedom of heroes to keep thier identies secret, as had been tradition";
        option34 = "Charges imposed by Government on Avengers";
        option41 = "Captin Amerca - Civil War";
        option42 = "Captain America - Winter Soldier";
        option43 = "Avengers - Age of Ultron";
        option44 = "Captain America - The First Avenger";
        option51 = "The Invaders";
        option52 = "The Justice League";
        option53 = "The Hailors";
        option54 = "None of These";
    }
    private void findviewID(){
        captain_quiz  = (TextView)findViewById(R.id.captain_quiz);
        hero_img = (ImageView) findViewById(R.id.hero_img);
        option1 = (RadioButton)findViewById(R.id.option1);
        option2 = (RadioButton)findViewById(R.id.option2);
        option3 = (RadioButton)findViewById(R.id.option3);
        option4 = (RadioButton)findViewById(R.id.option4);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ques_and_ans();
        findviewID();

       LayoutInflater lf = getLayoutInflater();
        final View instruct = lf.inflate(R.layout.activity_instructions, (ViewGroup)findViewById(R.id.instructions_inflate));
         final RelativeLayout r = (RelativeLayout)findViewById(R.id.quiz_relative_layout);
        r.addView(instruct);

        instructions_voice_mp3 = MediaPlayer.create(Quiz.this,R.raw.instruction_voice);
        instructions_voice_mp3.start();


        final CheckBox continue_quiz= (CheckBox)findViewById(R.id.checkBox);
        continue_quiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(continue_quiz.isChecked())
                {
                    continue_quiz.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            instructions_voice_mp3.release();
                            r.removeView(instruct);
                        }
                    }, 500);
                }
            }
        });




        ImageButton next = (ImageButton)findViewById(R.id.next);
        Intent in = getIntent();
        String stringVal = in.getStringExtra("hero_name");

        switch (stringVal) {
            case "1":
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i)
                        {
                            case R.id.option1:
                                option1.setBackgroundColor(Color.RED);
                                option1.postDelayed(new Runnable() {

                                        @Override
                                        public void run() {
                                            option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                        }
                                    }, 1000);
                                if(encounter)
                                {
                                    counter2=counter2-1;
                                    encounter=false;
                                }
                                break;

                            case R.id.option2:
                                option2.setBackgroundColor(Color.GREEN);
                                if(encounter)
                                {
                                    counter2=counter2+4;
                                    encounter=false;
                                }
                                break;

                            case R.id.option3:
                                option3.setBackgroundColor(Color.RED);
                                option3.postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                    }
                                }, 1000);
                                if(encounter)
                                {
                                    counter2=counter2-1;
                                    encounter=false;
                                }
                                break;

                            case R.id.option4:
                                option4.setBackgroundColor(Color.RED);
                                option4.postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                    }
                                }, 1000);
                                if(encounter)
                                {
                                    counter2=counter2-1;
                                    encounter=false;
                                }
                                break;

                        }
                    }
                });

             next.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     switch (counter1)
                     {
                         case 2:
                             //question2 = "What is Cap's shield made from?";
                             radioGroup.clearCheck();
                             counter1=counter1+1;
                             encounter=true;
                             option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             hero_img.setImageResource(R.drawable.captain_shied);
                             captain_quiz.setText(question2);
                             option1.setText(option21);
                             option2.setText(option22);
                             option3.setText(option23);
                             option4.setText(option24);
                             radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                 @Override
                                 public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                     switch (i)
                                     {
                                         case R.id.option1:
                                             option1.setBackgroundColor(Color.GREEN);
                                             if(encounter)
                                             {
                                                 counter2=counter2+4;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option2:
                                             option2.setBackgroundColor(Color.RED);
                                             option2.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option3:
                                             option3.setBackgroundColor(Color.RED);
                                             option3.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option4:
                                             option4.setBackgroundColor(Color.RED);
                                             option4.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;
                                     }
                                 }
                             });

                             break;

                         case 3:
                             //question3 = "In Marvels Civil War Storyline, Steve Rogers fought for what?";
                             radioGroup.clearCheck();
                             counter1=counter1+1;
                             encounter=true;
                             option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                             option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                             option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                             option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
                             captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
                             hero_img.setImageResource(R.drawable.captain);
                             captain_quiz.setText(question3);
                             option1.setText(option31);
                             option2.setText(option32);
                             option3.setText(option33);
                             option4.setText(option34);
                             radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                 @Override
                                 public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                     switch (i)
                                     {
                                         case R.id.option1:
                                             option1.setBackgroundColor(Color.RED);
                                             option1.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option2:
                                             option2.setBackgroundColor(Color.RED);
                                             option2.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option3:
                                             option3.setBackgroundColor(Color.GREEN);
                                             if(encounter)
                                             {
                                                 counter2=counter2+4;
                                                 encounter=false;
                                             }
                                             break;
                                         case R.id.option4:
                                             option4.setBackgroundColor(Color.RED);
                                             option4.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;
                                     }
                                 }
                             });
                             break;

                         case 4:
                             //question4 = "This Pic is from which Marvel movie?";
                             radioGroup.clearCheck();
                             counter1=counter1+1;
                             encounter=true;
                             option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
                             option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
                             option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
                             option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
                             captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25f);
                         hero_img.setImageResource(R.drawable.captain_helicopter);
                         captain_quiz.setText(question4);
                         option1.setText(option41);
                         option2.setText(option42);
                         option3.setText(option43);
                         option4.setText(option44);
                             radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                 @Override
                                 public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                     switch (i)
                                     {
                                         case R.id.option1:
                                             option1.setBackgroundColor(Color.RED);
                                             option1.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option2:

                                         option2.setBackgroundColor(Color.GREEN);
                                         if(encounter)
                                         {
                                             counter2=counter2+4;
                                             encounter=false;
                                         }
                                         break;


                                         case R.id.option3:
                                             option3.setBackgroundColor(Color.RED);
                                             option3.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option4:
                                             option4.setBackgroundColor(Color.RED);
                                             option4.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;
                                     }
                                 }
                             });
                         break;

                         case 5:
                            //question5 = "What group of superheroes did Captain America team up with before the Avengers?";
                             radioGroup.clearCheck();
                             counter1=counter1+1;
                             encounter=true;
                             option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                             option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21f);
                             option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21f);
                             option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21f);
                             option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21f);
                             captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 23f);
                             hero_img.setImageResource(R.drawable.captian4);
                             captain_quiz.setText(question5);
                             option1.setText(option51);
                             option2.setText(option52);
                             option3.setText(option53);
                             option4.setText(option54);
                             radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                 @Override
                                 public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                     switch (i)
                                     {
                                         case R.id.option1:
                                             option1.setBackgroundColor(Color.GREEN);
                                             if(encounter)
                                             {
                                                 counter2=counter2+4;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option2:
                                             option2.setBackgroundColor(Color.RED);
                                             option2.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;


                                         case R.id.option3:
                                             option3.setBackgroundColor(Color.RED);
                                             option3.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;

                                         case R.id.option4:
                                             option4.setBackgroundColor(Color.RED);
                                             option4.postDelayed(new Runnable() {

                                                 @Override
                                                 public void run() {
                                                     option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                                                 }
                                             }, 1000);
                                             if(encounter)
                                             {
                                                 counter2=counter2-1;
                                                 encounter=false;
                                             }
                                             break;
                                     }
                                 }
                             });
                             break;


                         case 6:
                             Intent in = new Intent(Quiz.this,Score.class);
                             in.putExtra("final_score",counter2);
                             startActivity(in);
                             break;

                     }

                 }
             });

            break;


            case "2":
                hero_img.setImageResource(R.drawable.iron_man2);
                break;
        }

        }

}
