package com.seon.photoapp;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by student on 2015-11-18.
 */
public class DetailActivity extends AppCompatActivity {
    String TAG;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**/
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");

       Bitmap bitmap= bundle.getParcelable("img");
        Log.d(TAG,"bitmap:"+bitmap);

        imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}
