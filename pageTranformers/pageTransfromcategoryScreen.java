package com.abhijit.factsapp.pageTranformers;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class pageTransfromcategoryScreen implements ViewPager.PageTransformer{
        private float smallScale = 0.65f;
        public pageTransfromcategoryScreen(){

        }
        @Override
        public void transformPage(@NonNull View view, float v) {
            float abs = Math.abs(v);


            if(abs>=1){

                view.setScaleY(smallScale);
                view.setAlpha(smallScale);
            }else{

                view.setScaleY((smallScale-1)*abs+1);
                view.setAlpha((smallScale-1)*abs+1);
            }


        }

}
