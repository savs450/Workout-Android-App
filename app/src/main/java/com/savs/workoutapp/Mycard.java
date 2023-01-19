package com.savs.workoutapp;

public class Mycard {
    private int mImageResource;
    private String mtext;
    public Mycard( int img, String txt){
        mImageResource = img;
        mtext = txt;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getMtext() {
        return mtext;
    }
}
