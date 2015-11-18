package com.seon.photoapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class albumActivity extends Activity implements AdapterView.OnItemClickListener{
    GridView gridView;
    AlbumAdapter albumAdapter;
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_layout);
        TAG=this.getClass().getName();
        gridView=(GridView)findViewById(R.id.gridView);
        albumAdapter=new AlbumAdapter(this);
        gridView.setAdapter(albumAdapter);  //연결

        gridView.setOnItemClickListener(this);  //리스너와 연결

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, position + "번째 눌렀엉?");
        Intent intent =new Intent(this,DetailActivity.class);
        /*앨범에서 선택한 ImageView를 전달해보자!!
        * 주의) Intent 가 대부분 기본자료형에 대한 전달만 지원하기 때문에 Bundle이 지원하는 putExtraParcelable
        * */
        ImageView imageView=(ImageView)view;
        imageView.setDrawingCacheEnabled(true);
        Bitmap bitmap=imageView.getDrawingCache();
        Bundle bundle=new Bundle();
        bundle.putParcelable("img", bitmap);
        intent.putExtra("bundle",bundle);

        startActivity(intent);
    }
    public void btnClick(View view){

        finish();
    }

}
