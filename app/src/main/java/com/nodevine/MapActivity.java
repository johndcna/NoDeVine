package com.nodevine;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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
    DatabaseMap myDB;
    boolean map1,map2,map3,map4;
    boolean map5,map6,map7,map8;
    boolean map9,map10,map11,map12;
    boolean map13,map14,map15,map16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map);

        myDB = new DatabaseMap(this);

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

    public void populate() {
        if(!tableIsEmpty()) {

        }
    }

    public void viewAllData() {
        Cursor res = myDB.getAllData();

        while(res.moveToNext()) {
            //buffer.append("id: "+res.getString(0)+"\n");
        }
    }

    public boolean tableIsEmpty() {
        Cursor res = myDB.getAllData();
        return (res.getCount() == 0)?true:false;
    }

    public void onClick(View v) {

         switch (v.getId()) {
             case R.id.imageButton1:
                 break;


         }
    }

    public ImageButton getImageButton(String loc) {
        switch (loc) {
            case "1":
                return imgBtn[0];
            case "2":
                return imgBtn[1];
            case "3":
                return imgBtn[2];
            case "4":
                return imgBtn[3];
            case "5":
                return imgBtn[4];
            case "6":
                return imgBtn[5];
            case "7":
                return imgBtn[6];
            case "8":
                return imgBtn[7];
            case "9":
                return imgBtn[8];
            case "10":
                return imgBtn[9];
            case "11":
                return imgBtn[10];
            case "12":
                return imgBtn[11];
            case "13":
                return imgBtn[12];
            case "14":
                return imgBtn[13];
            case "15":
                return imgBtn[14];
            case "16":
                return imgBtn[15];
        }

        return null;
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
