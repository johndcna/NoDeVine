package com.nodevine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void goBuild(View view) {
        Intent intent = new Intent(this,ProcessingActivity.class);
        startActivity(intent);
    }

    public void goSettings(View view) {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }

    public void goMarket(View view) {
        Intent intent = new Intent(this,MarketActivity.class);
        startActivity(intent);
    }
    public void goMap(View view) {
        Intent intent = new Intent(this,MapActivity.class);
        startActivity(intent);
    }
}
