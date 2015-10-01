package com.example.android.popularmovies.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.popularmovies.MainActivity;
import com.example.android.popularmovies.R;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c){
        mContext = c;
    }

    public int getCount() {
        return MainActivity.arrayMovies.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(mContext);
            //Tamanho da Imagem no GridView
            imageView.setLayoutParams(new GridView.LayoutParams(250, 350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(MainActivity.arrayMovies.get(position).getPosterImage());
        return imageView;
    }

}
