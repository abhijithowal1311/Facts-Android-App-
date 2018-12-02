package com.abhijit.factsapp.Model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;

import java.io.Serializable;

public class model {


    private String title;
    private Drawable mDrawable;
    private Drawable gradientBackground;

    public model(String title, Drawable mDrawable) {
        this.title = title;
        this.mDrawable = mDrawable;
    }

    public model(String title, Drawable drawable, Drawable gradientBackground) {
        this.title = title;
        mDrawable = drawable;
        this.gradientBackground = gradientBackground;
    }

    public Drawable getGradientBackground() {
        return gradientBackground;
    }

    public void setGradientBackground(Drawable gradientBackground) {
        this.gradientBackground = gradientBackground;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getColor() {
        return mDrawable;
    }

    public void setColor(int color) {
        this.mDrawable = mDrawable;
    }
}
