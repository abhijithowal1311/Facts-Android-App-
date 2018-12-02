package com.abhijit.factsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.abhijit.factsapp.Model.dogModel;

import java.io.Serializable;
import java.util.List;

public class CategoryMainActivity extends AppCompatActivity {

    Fragment mFragment;
    FragmentManager mFragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_main);

        int pos =getIntent().getIntExtra("Position",0);
            dogModel dm = new dogModel();
            List<String> list = dm.getList(pos);
         mFragmentManager=getSupportFragmentManager();
        mFragmentManager=getSupportFragmentManager();
        mFragment=new categoryScreen();
        Bundle bundle = new Bundle();
        bundle.putInt("pos",pos);
        mFragment.setArguments(bundle);
        mFragmentManager.beginTransaction().add(R.id.container2,mFragment,null).commit();

    }
}
