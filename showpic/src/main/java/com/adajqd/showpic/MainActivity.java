package com.adajqd.showpic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private SurfaceView mSurfaceView;
    private CustomView mCustomView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv);
        mSurfaceView = (SurfaceView) findViewById(R.id.surface_view);
        mCustomView = (CustomView) findViewById(R.id.custom_view);

        // 使用ImageView绘制图片
        //showPicWithImageView();

        // 使用SurfaceView绘制图片
        //showPicWithSurfaceView();

        // 使用CustomView绘制图片
        showPicWithCustomView();
    }


    private void showPicWithImageView() {
        mImageView.setVisibility(View.VISIBLE);
        mSurfaceView.setVisibility(View.GONE);
        mCustomView.setVisibility(View.GONE);
        mImageView.setBackgroundResource(R.mipmap.taylor);
    }


    private void showPicWithSurfaceView() {
        mImageView.setVisibility(View.GONE);
        mSurfaceView.setVisibility(View.VISIBLE);
        mCustomView.setVisibility(View.GONE);
        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

                if (surfaceHolder == null) {
                    return;
                }

                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.taylor);
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawBitmap(bitmap, 0, 0, paint);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }


            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }


            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }


    private void showPicWithCustomView() {
        mImageView.setVisibility(View.GONE);
        mSurfaceView.setVisibility(View.GONE);
        mCustomView.setVisibility(View.VISIBLE);
    }
}
