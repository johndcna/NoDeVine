package com.nodevine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageButton;

import java.util.Collections;


public class MapActivity extends Activity implements View.OnClickListener {
    int hh,mm,ss;
    ImageButton[] imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        if(intent !=null) {
            hh = intent.getIntExtra("hour",0);
            mm = intent.getIntExtra("min", 0);
            ss = intent.getIntExtra("sec", 0);
        }
        imgBtn = new ImageButton[16];
        initializeImageButton();

        for(int i=0;i<16;i++) {
            imgBtn[i].setOnClickListener((OnClickListener) this);
        }


        Log.e("seconds",""+getSeconds(hh,mm,ss));

    }

    public void onClick(View v) {

         switch (v.getId()) {
             case R.id.imageButton1:
                 break;


         }
    }

    public void initializeImageButton() {
        imgBtn[0] = (ImageButton)findViewById(R.id.imageButton1);
        imgBtn[1] = (ImageButton)findViewById(R.id.imageButton2);
        imgBtn[2] = (ImageButton)findViewById(R.id.imageButton3);
        imgBtn[3] = (ImageButton)findViewById(R.id.imageButton4);

        imgBtn[4] = (ImageButton)findViewById(R.id.imageButton5);
        imgBtn[5] = (ImageButton)findViewById(R.id.imageButton6);
        imgBtn[6] = (ImageButton)findViewById(R.id.imageButton7);
        imgBtn[7] = (ImageButton)findViewById(R.id.imageButton8);

        imgBtn[8] = (ImageButton)findViewById(R.id.imageButton9);
        imgBtn[9] = (ImageButton)findViewById(R.id.imageButton10);
        imgBtn[10] = (ImageButton)findViewById(R.id.imageButton11);
        imgBtn[11] = (ImageButton)findViewById(R.id.imageButton12);

        imgBtn[12] = (ImageButton)findViewById(R.id.imageButton13);
        imgBtn[13] = (ImageButton)findViewById(R.id.imageButton14);
        imgBtn[14] = (ImageButton)findViewById(R.id.imageButton15);
        imgBtn[15] = (ImageButton)findViewById(R.id.imageButton16);
    }

    public int getSeconds(int hh,int mm,int ss) {
        return (hh * 3600) + (mm * 60) + ss;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
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
}
