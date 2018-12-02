package com.abhijit.factsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;


public class MainActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    Fragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager=getSupportFragmentManager();
        Fragment MainScreen  =new MainScreen();
        mFragmentManager.beginTransaction().add(R.id.container,MainScreen,null).commit();
        }




}
