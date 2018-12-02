package com.abhijit.factsapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.abhijit.factsapp.UIUtils.*;
import com.abhijit.factsapp.R;

import java.util.ArrayList;
import java.util.List;


public class categoryVPadapter extends PagerAdapter {
        List<String> stringlist;
        Context mContext;
        int position1;

       List<Drawable> mDrawables=new ArrayList<>();
       public categoryVPadapter(List<String> s,Context c,int pos){
            stringlist =s;
            mContext=c;
            position1=pos;
            mDrawables.add(mContext.getResources().getDrawable(R.drawable.gradient1));
            mDrawables.add(mContext.getResources().getDrawable(R.drawable.gradient2));
            mDrawables.add(mContext.getResources().getDrawable(R.drawable.gradient4));
            mDrawables.add(mContext.getResources().getDrawable(R.drawable.gradient3));
            mDrawables.add(mContext.getResources().getDrawable(R.drawable.gradient5));
        }


        @Override
        public int getCount() {
            return stringlist.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View v=LayoutInflater.from(mContext).inflate(R.layout.category_main_screen_items,container,false);
            ConstraintLayout mc=v.findViewById(R.id.mc);

            TextView mText=v.findViewById(R.id.textfact);

            mc.setBackground(mDrawables.get(position1));

            mText.setText(stringlist.get(position));
            container.addView(v,0);
            return v;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view.equals(o);
        }
    }
