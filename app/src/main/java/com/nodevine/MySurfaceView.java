package com.nodevine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by John on 2/27/2016.
 */
public class MySurfaceView  extends SurfaceView implements Runnable {
    SurfaceHolder holder;
    BuildSprite buildSprite;


    public MySurfaceView(Context context) {
        super(context);
        buildSprite = new BuildSprite(this);
        holder = this.getHolder();
        new Thread(this).start();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context,attrs);
        buildSprite = new BuildSprite(this);
        holder = this.getHolder();
        new Thread(this).start();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context,attrs,defStyle);
        buildSprite = new BuildSprite(this);
        holder = this.getHolder();
        new Thread(this).start();
    }



    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (true) {
            if (!holder.getSurface().isValid()) {
                continue;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Canvas canvas = holder.lockCanvas();
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.holo_blue_light));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(0,0,getWidth(),getHeight(),paint);
            canvas.drawBitmap(buildSprite.getMove(),1,1, paint);
            holder.unlockCanvasAndPost(canvas);
        }
    }
}