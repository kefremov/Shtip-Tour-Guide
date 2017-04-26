package com.example.android.shtiptourguide;

public class Object {


    private String mTitle;
    private int mImageResourceID;
    private String mUrl;
    private String mGeo;

    public Object(int imageResourceID, String title, String url, String geo) {
        mImageResourceID = imageResourceID;
        mTitle = title;
        mUrl = url;
        mGeo =  geo;
    }


    public int getImageResourceID() {

        return mImageResourceID;
    }

    public String getTitle() {

        return mTitle;
    }

    public String getUrl() {

        return mUrl;
    }

    public String getGeo() {

        return mGeo;
    }

}
