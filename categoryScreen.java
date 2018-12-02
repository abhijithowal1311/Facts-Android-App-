package com.abhijit.factsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.abhijit.factsapp.Model.*;
import com.abhijit.factsapp.adapter.*;
import com.abhijit.factsapp.pageTranformers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class categoryScreen extends Fragment {
    ViewPager mCoolViewPager;
    List<String> mStrings;
    TextView mTextView;
    int pos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mStrings = new ArrayList<>();

        //getting the position from the parent activity
        Bundle bd = new Bundle();
        bd=getArguments();
        dogModel d =new dogModel();
         pos= bd.getInt("pos");

        //fetching the list from the model class
        mStrings=d.getList(pos);
        View v= inflater.inflate(R.layout.cateogry_main_screen,container,false);
        mCoolViewPager =v.findViewById(R.id.coolvp);
        mTextView= v.findViewById(R.id.factno);
        mTextView.setText("Fact Number "+"1");

        //sets adapter and pageTransformers
        updateUI();
        return v;

    }

    public void updateUI(){
        categoryVPadapter a =new categoryVPadapter(mStrings,getActivity(),pos);
        mCoolViewPager.setAdapter(a);
         pageTransfromcategoryScreen p =new pageTransfromcategoryScreen();
        mCoolViewPager.setPageTransformer(false,p);
        mCoolViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                mTextView.setText("Fact Number "+(i+1));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
