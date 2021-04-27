package com.android.edinpuritytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class HomeScreen extends Activity {

    Button beginBtn,contactBtn;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        createPersonalisedAd();

        AdView mAdView;
        mAdView = findViewById(R.id.bottomAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        beginBtn = (Button) findViewById(R.id.beginBtn);
            beginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(HomeScreen.this);
                    } else {
                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        openQuestionsActivity();
                    }
                }
            });

        contactBtn = (Button) findViewById(R.id.contactBtn);
        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactActivity();
            }
        });
    }

    public void openQuestionsActivity(){
        Intent intent = new Intent(this, Questions.class);
        startActivity(intent);
    }
    public void openContactActivity(){
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }
    private void createPersonalisedAd()
    {
        AdRequest adRequest = new AdRequest.Builder().build();
        createIntestitialAd(adRequest);
    }
    private void createIntestitialAd(AdRequest adRequest)
    {
        //Test Ad ID : ca-app-pub-3940256099942544/1033173712
        //My Ad ID: ca-app-pub-6105353816616318/7961309321
        InterstitialAd.load(this,"ca-app-pub-6105353816616318/7961309321", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.d("TAG", "onAdLoaded");

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.
                        Log.d("TAG", "The ad was dismissed.");
                        openQuestionsActivity();
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when fullscreen content failed to show.
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.d("TAG", loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });
    }
}
