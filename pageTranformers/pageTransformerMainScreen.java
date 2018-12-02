package com.abhijit.factsapp.pageTranformers;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class pageTransformerMainScreen implements ViewPager.PageTransformer {

    @Override
    public void transformPage(@NonNull View view, float v) {
        float abs = Math.abs(v);
        if(abs >=1){
            view.setScaleY(0.75f);
            view.setAlpha(0.7f);
        }
        else{
            view.setScaleY((0.75f-1)*abs+1);
            view.setAlpha((0.75f-1)*abs+1);
        }
    }
}