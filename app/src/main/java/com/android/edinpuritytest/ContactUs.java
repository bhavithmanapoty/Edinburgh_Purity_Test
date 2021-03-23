package com.android.edinpuritytest;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ContactUs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);

        AdView mAdView;
        mAdView = findViewById(R.id.bottomAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView topAdView;
        topAdView = findViewById(R.id.topAdView);
        topAdView.loadAd(adRequest);
    }
}
