package com.nodevine;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Chronometer;
import android.widget.TextView;


public class ProcessingActivity extends Activity {
    TextView textGoesHere;
    long startTime;
    String hh;
    String mm;
    String ss;
    Chronometer stopWatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_processing);

        stopWatch = (Chronometer) findViewById(R.id.chronometer);
        startTime = SystemClock.elapsedRealtime();

        textGoesHere = (TextView) findViewById(R.id.editText);
        stopWatch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer arg0) {
                /*countUp = (SystemClock.elapsedRealtime() - arg0.getBase()) / 1000;
                String asText = ((countUp/60)/60) +":"+ (countUp / 60) + ":" + (countUp % 60);
                textGoesHere.setText(asText);*/
                long time = SystemClock.elapsedRealtime() - arg0.getBase();
                int h   = (int)(time/3600000);
                int m = (int)(time - h*3600000)/60000;
                int s= (int)(time - h*3600000- m*60000)/1000 ;
                 hh = h < 10 ? "0"+h: h+"";
                 mm = m < 10 ? "0"+m: m+"";
                 ss = s < 10 ? "0"+s: s+"";
                textGoesHere.setText(hh+":"+mm+":"+ss);
            }
        });
        stopWatch.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_processing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void runMap(int h,int m,int s) {
        Intent intent = new Intent(this,MapActivity.class);
        intent.putExtra("hour",h);
        intent.putExtra("min",m);
        intent.putExtra("sec",s);
        startActivityForResult(intent,0);
    }

    public void goConstruct(View v) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        stopWatch.stop();
                        runMap(Integer.parseInt(hh),Integer.parseInt(mm),Integer.parseInt(ss));
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        Log.e("click", "no");
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }


}
