package com.abhijit.factsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.abhijit.factsapp.pageTranformers.*;
import com.abhijit.factsapp.adapter.mainScreenAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.abhijit.factsapp.UIUtils.backgroundChanger;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.abhijit.factsapp.Model.*;
import java.util.ArrayList;
import java.util.List;
import io.github.kobakei.materialfabspeeddial.FabSpeedDial;


public class MainScreen extends Fragment {
    ViewPager mViewPager;
    RecyclerView mRecyclerView;
    private List<model> Categoriesm;
    FloatingActionButton fab;
    private FrameLayout mFrameLayout;
    FabSpeedDial mFabSpeedDial;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Categoriesm =new ArrayList<>();
        Categoriesm.add(new model("Dogs",getResources().getDrawable(R.drawable.dogs),getResources().getDrawable(R.drawable.gradient1)));
        Categoriesm.add(new model(" Human Body ",getResources().getDrawable(R.drawable.lung2),getResources().getDrawable(R.drawable.gradient2)));
        Categoriesm.add(new model("Ocean",getResources().getDrawable(R.drawable.whale),getResources().getDrawable(R.drawable.gradient4)));
        Categoriesm.add(new model("Space",getResources().getDrawable(R.drawable.space1),getResources().getDrawable(R.drawable.gradient3)));
        Categoriesm.add(new model("Animals",getResources().getDrawable(R.drawable.snake),getResources().getDrawable(R.drawable.gradient5)));
    }

      //         Bitmap bip= BitmapFactory.decodeResource(getResources(),R.drawable.solar_system);
      //            bip2 = Bitmap.createScaledBitmap(bip,400,250,true);
      // mImageView.setImageBitmap(bip2);
    private boolean visible=true;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_screen,container,false);
        mRecyclerView = view.findViewById(R.id.timeline);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mViewPager = view.findViewById(R.id.viewPager);
        mFabSpeedDial=view.findViewById(R.id.fabm);

        mFabSpeedDial.addOnMenuItemClickListener(new FabSpeedDial.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(FloatingActionButton miniFab, @Nullable TextView label, int itemId) {
                    if(itemId == R.id.menu1){
                        Toast.makeText(getActivity(),"credits page",Toast.LENGTH_SHORT).show();
                    }else if(itemId == R.id.menu2){
                        if(visible == true){
                            mRecyclerView.setVisibility(View.INVISIBLE);
                            ConstraintLayout.LayoutParams params= (ConstraintLayout.LayoutParams) mViewPager.getLayoutParams();
                            params.setMargins(0,0,0,4);
                            mViewPager.setLayoutParams(params);
                            visible=false;
                        }
                        else{
                            mRecyclerView.setVisibility(View.VISIBLE);
                            ConstraintLayout.LayoutParams params= (ConstraintLayout.LayoutParams) mViewPager.getLayoutParams();
                            float margintop=52*getResources().getDisplayMetrics().density;
                            params.setMargins(0,(int)margintop,0,4);
                            mViewPager.setLayoutParams(params);
                            visible=true;
                        }
                    }
            }
        });
        updateUI();
        return view;
    }

    //sets adapter for viewpager and recyclerview
    public void updateUI(){
        adapter m = new adapter(Categoriesm);
        mRecyclerView.setAdapter(m);
        mainScreenAdapter adapter = new mainScreenAdapter(getActivity(),Categoriesm);
        mViewPager.setAdapter(adapter);
        pageTransformerMainScreen p =new pageTransformerMainScreen();
        mViewPager.setPageTransformer(false,p);
        mViewPager.setPadding(80,0,80,0);
        mViewPager.setBackground(getResources().getDrawable(R.drawable.gradient1));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                mViewPager.setBackground(Categoriesm.get(i).getGradientBackground());
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }


    //Top RecyclerView Viewholder
    private class viewhold extends RecyclerView.ViewHolder{
        Button mButton;
        model abc;
        int pos;
        public viewhold(@NonNull View itemView) {
            super(itemView);
            mButton=itemView.findViewById(R.id.button2);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mViewPager!=null){
                        mViewPager.setCurrentItem(pos);
                        mButton.setScaleX(1f);
                        mButton.setScaleY(1f);
                    }
                }
            });


        }
        public void bind(model a,int position){
            abc= a;
            pos=position;
            mButton.setBackground(a.getGradientBackground());
            mButton.setText(a.getTitle());
        }
    }

    //Top RecyclerView adapter
    private class adapter extends RecyclerView.Adapter<viewhold>{
            List<model> list;
        adapter(List<model> modelList){
            list =modelList;
        }

        @NonNull
        @Override
        public viewhold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v= LayoutInflater.from(getActivity()).inflate(R.layout.recycler_item,viewGroup,false);
            viewhold vh = new viewhold(v);

            return vh;
        }
        @Override
        public void onBindViewHolder(@NonNull viewhold viewhold, int i) {
                  viewhold.bind(list.get(i),i);
        }
        @Override
        public int getItemCount() {
            return list.size();
        }
    }

}
