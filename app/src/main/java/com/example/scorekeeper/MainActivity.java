package com.example.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {


    private TextView mScore1;
    private TextView mScore2;

    private int mCount1 = 0;
    private int mCount2 = 0;

    static final String STATE_SCORE_1 = "";
    static final String STATE_SCORE_2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScore1 = (TextView)findViewById(R.id.score1);
        mScore2 = (TextView)findViewById(R.id.score2);

        System.out.println(savedInstanceState);

        if(savedInstanceState != null){
            mCount1 = savedInstanceState.getInt(STATE_SCORE_1);
            mCount2 = savedInstanceState.getInt(STATE_SCORE_2);

            mScore1.setText(String.valueOf(mCount1));
            mScore2.setText(String.valueOf(mCount2));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            recreate();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mCount1);
        outState.putInt(STATE_SCORE_2, mCount2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }


        return true;
    }

    public void decreaseScore(View view){
        int viewID = view.getId();
        switch(viewID){
            case R.id.minus_team1:
                mCount1--;
                mScore1.setText(String.valueOf(mCount1));
                break;
            case R.id.minus_team2:
                mCount2--;
                mScore2.setText(String.valueOf(mCount2));

        }
    }

    public void increaseScore(View view){
        int viewID = view.getId();
        switch(viewID){
            case R.id.plus_team1:
                mCount1++;
                mScore1.setText(String.valueOf(mCount1));
                break;
            case R.id.plus_team2:
                mCount2++;
                mScore2.setText(String.valueOf(mCount2));
        }
    }
}
