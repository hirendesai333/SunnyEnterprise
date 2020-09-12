package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.Banner;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FlipperAdapter extends BaseAdapter {
    private Context mCtx;
    private List<Banner> banners;

    public FlipperAdapter(Context mCtx, List<Banner> banners) {
        this.mCtx = mCtx;
        this.banners = banners;
    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Banner banner = banners.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.flipper_items, null);
        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);
        textView.setText(banner.getText());

        Picasso.get().load(banner.getImgURL()).into(imageView);
        return view;
    }
}
