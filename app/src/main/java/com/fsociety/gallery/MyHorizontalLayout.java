package com.fsociety.gallery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MyHorizontalLayout extends LinearLayout {

    Context myContext;
    ArrayList<String> itemList = new ArrayList<String>();
    ImageView externalImageView;



    public MyHorizontalLayout(Context context) {
        super(context);
        myContext = context;
    }

    public MyHorizontalLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        myContext = context;
    }

    public MyHorizontalLayout(Context context, AttributeSet attrs,
                              int defStyle) {
        super(context, attrs, defStyle);
        myContext = context;
    }

    public void setExternalImageView(Context context, ImageView imageView){
        this.externalImageView=imageView;
        myContext=context;





    }

    void add(List<Bitmap> bitmaps){
        LayoutParams layoutParams  = new LayoutParams(300,300);
        layoutParams.setMargins(20,20,20,20);

        for( final Bitmap bm :bitmaps) {

            ImageView imageView = new ImageView(myContext);


            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageBitmap(bm);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    externalImageView.setImageBitmap(bm);
                    Toast.makeText(myContext, "clicked", Toast.LENGTH_SHORT).show();

                }
            });
            addView(imageView);

        }
    }

















   /* public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {
        Bitmap bm = null;

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }*/
/*
    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }
        }

        return inSampleSize;
    }*/

}