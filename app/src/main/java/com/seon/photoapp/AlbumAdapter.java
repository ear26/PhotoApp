package com.seon.photoapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;


public class AlbumAdapter extends BaseAdapter {
    Context context;
    ArrayList<ImageView> list=new ArrayList<ImageView>();


    public AlbumAdapter(Context context) {
        this.context=context;
        init();
    }

    /*SD카드내의 사진이 있는 경로를 조사하여, ArrayList에 담아서 사진출력!!*/

    public void init(){
        String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/MyMedia/photo";

        File file=new File(path);
        File listFile[]=file.listFiles();

        for(int i=0;i<listFile.length;i++){
            if(listFile[i].isFile()){
                //directory가 아닌 file이라면
                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inSampleSize=8;
                Bitmap bitmap= BitmapFactory.decodeFile(listFile[i].getAbsolutePath(),options);

                            /*그래픽의 왜곡처리를 담당하는 객체인 Matrix써 본다.*/
                Matrix matrix=new Matrix();
                matrix.postRotate(90);
                Bitmap rotateBitmap=Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

                ImageView imageView=new ImageView(context);
                imageView.setImageBitmap(rotateBitmap);
                list.add(imageView);



            }
        }
    }
    public int getCount() {

        return list.size();
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        view= list.get(position);
        return view;
    }
}
