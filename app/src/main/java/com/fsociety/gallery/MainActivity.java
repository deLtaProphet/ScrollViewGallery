package com.fsociety.gallery;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {

    MyHorizontalLayout myHorizontalLayout;
    ImageView imageView;
    List<Bitmap> bitmaps = new ArrayList<>();
    PhotoViewAttacher photoViewAttacher;
    private static final String[] images = new String[]{
            "http://img1.goodfon.ru/original/1920x1080/d/f5/aircraft-jet-su-47-berkut.jpg",
            "http://www.dishmodels.ru/picture/glr/13/13312/g13312_7657277.jpg",
            "http://img2.goodfon.ru/original/1920x1080/b/c9/su-47-berkut-c-37-firkin.jpg" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHorizontalLayout = (MyHorizontalLayout) findViewById(R.id.mygallery);
        imageView = (ImageView) findViewById(R.id.external_image_view);
        photoViewAttacher = new PhotoViewAttacher(imageView);
        myHorizontalLayout.setExternalImageView(this,imageView);
        new ImageLoader().execute(images);



    }

    class ImageLoader extends AsyncTask<String, Void, Void> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                for (String s : params) {
                    Bitmap bm = Picasso.with(MainActivity.this).load(s).get();
                    bitmaps.add(bm);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


                myHorizontalLayout.add(bitmaps);

            progressDialog.dismiss();
        }
    }
}
