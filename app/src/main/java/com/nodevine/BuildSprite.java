package com.nodevine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


/**
 * Created by John on 2/27/2016.
 */
public class BuildSprite {
    MySurfaceView ma;
    Bitmap build[] = new Bitmap[7];
    int move = 0;
    int sequence = 0;
    public BuildSprite(MySurfaceView m)
    {
        ma = m;
        build[0] = BitmapFactory.decodeResource(ma.getResources(), R.drawable.build1);
        build[1] = BitmapFactory.decodeResource(ma.getResources(), R.drawable.build2);
        build[2] = BitmapFactory.decodeResource(ma.getResources(), R.drawable.build3);
        build[3] = BitmapFactory.decodeResource(ma.getResources(), R.drawable.build4);
        build[4] = BitmapFactory.decodeResource(ma.getResources(), R.drawable.build5);
        build[5] = BitmapFactory.decodeResource(ma.getResources(), R.drawable.build6);
        build[6] = BitmapFactory.decodeResource(ma.getResources(), R.drawable.build7);

    }

    public Bitmap getMove()
    {
        Bitmap b = build[0];
        switch(move)
        {
            // Stand
            case 0:
                b =  build[sequence];
                sequence++;
                sequence = (sequence >=6 )? 0: sequence;
                break;
        }

        return b;
    }
}
