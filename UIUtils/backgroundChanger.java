package com.abhijit.factsapp.UIUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.abhijit.factsapp.R;

import java.util.ArrayList;
import java.util.List;

public class backgroundChanger {

    List<Drawable> backgroundList=new ArrayList<>();
    public backgroundChanger(Context mContext){
        backgroundList.add(mContext.getResources().getDrawable(R.drawable.gradient1));
        backgroundList.add(mContext.getResources().getDrawable(R.drawable.gradient2));
        backgroundList.add(mContext.getResources().getDrawable(R.drawable.gradient3));
        backgroundList.add(mContext.getResources().getDrawable(R.drawable.gradient5));
        backgroundList.add(mContext.getResources().getDrawable(R.drawable.gradient4));
    }

    public Drawable getBackground(int pos){
      return  backgroundList.get(pos);
    }

}
