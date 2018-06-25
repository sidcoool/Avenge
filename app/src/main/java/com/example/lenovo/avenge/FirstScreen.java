package com.example.lenovo.avenge;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FirstScreen extends AppCompatActivity {
    MediaPlayer aven_theme;
    private static  final int [] IMAGES = {R.drawable.captain,R.drawable.iron_man,R.drawable.hulk,R.drawable.thor,R.drawable.doctor3,R.drawable.blackwidow2,R.drawable.spider2,R.drawable.guardians};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        aven_theme = MediaPlayer.create(FirstScreen.this,R.raw.avengers_theme_song);
        aven_theme.start();
        AdapterViewFlipper heroFlipper = (AdapterViewFlipper) findViewById(R.id.Flipping_Heroes);

        Flipper adapter = new Flipper(this,IMAGES);
        heroFlipper.setAdapter(adapter);
        heroFlipper.setAutoStart(true);

        heroFlipper.postDelayed(new Runnable() {

            @Override
            public void run() {
                aven_theme.release();
                Intent in = new Intent(FirstScreen.this,Hero_List.class);
                startActivity(in);
            }
        }, 4000);


    }
    class Flipper extends BaseAdapter{

        Context ctx;
        int [] images;
        LayoutInflater inflater;
        Flipper(Context context, int[] HeroesImages)
        {
            this.ctx = context;
            this.images = HeroesImages;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
             view = inflater.inflate(R.layout.flipper_items,null);
            ImageView v = (ImageView)view.findViewById(R.id.flip);
            v.setImageResource(images[i]);
            return view;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        aven_theme.release();
        finish();
    }


    }

