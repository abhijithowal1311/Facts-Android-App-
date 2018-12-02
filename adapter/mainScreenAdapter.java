package com.abhijit.factsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abhijit.factsapp.CategoryMainActivity;
import com.abhijit.factsapp.Model.model;
import com.abhijit.factsapp.R;

import java.util.List;

public class mainScreenAdapter extends PagerAdapter {

    List<model> mModelList;
    private Context mContext;
    public mainScreenAdapter(Context mContext, List<model> modelList){
        this.mContext = mContext;
        mModelList = modelList;
    }

    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.main_screen_items,container,false);
        ImageView mImageview= v.findViewById(R.id.imageview);
        TextView mTextview= v.findViewById(R.id.text101);
        CardView mCard = v.findViewById(R.id.cardview);
        mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager mvp=(ViewPager)container;
                Intent i=new Intent(mContext,CategoryMainActivity.class);
                i.putExtra("Position",mvp.getCurrentItem());
                mContext.startActivity(i);
            }
        });
        mImageview.setImageDrawable(mModelList.get(position).getColor());
        mTextview.setText(mModelList.get(position).getTitle());
        mTextview.setBackground(mModelList.get(position).getGradientBackground());
        container.addView(v,0);
        return v;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
    @Override
    public int getCount() {
        return mModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

}
