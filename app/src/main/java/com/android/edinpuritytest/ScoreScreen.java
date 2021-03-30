package com.android.edinpuritytest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class ScoreScreen extends Activity {

    private InterstitialAd mInterstitialAd;
    int btn;
    Button homeBtn, restartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_screen);

        String FinalScore = Integer.toString(Questions.score);
        LinearLayout lView = (LinearLayout)findViewById(R.id.score);
        TextView score = new TextView(this);
        score.setText(FinalScore);
        score.setTextColor(Color.parseColor("#ff1100"));
        score.setTextSize(48);
        lView.addView(score);


        createPersonalisedAd();

        AdView mAdView;
        mAdView = findViewById(R.id.bottomAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView topAdView;
        topAdView = findViewById(R.id.topAdView);
        topAdView.loadAd(adRequest);

        homeBtn = (Button)findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.score=100;
                if (mInterstitialAd != null) {
                    btn = 0;
                    mInterstitialAd.show(ScoreScreen.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    openHomePage();
                }
            }
        });

        restartBtn = (Button)findViewById(R.id.restartBtn);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.score=100;
                if (mInterstitialAd != null) {
                    btn = 1;
                    mInterstitialAd.show(ScoreScreen.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    openQuestionsActivity();
                }
            }
        });
    }
    private void openHomePage() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    public void openQuestionsActivity(){
        Intent intent = new Intent(this, Questions.class);
        startActivity(intent);
    }
    private void createPersonalisedAd()
    {
        AdRequest adRequest = new AdRequest.Builder().build();
        createIntestitialAd(adRequest);
    }
    private void createIntestitialAd(AdRequest adRequest)
    {
        InterstitialAd.load(this,"ca-app-pub-XXXX3816616318/7083341922", adRequest, new InterstitialAdLoadCallback() {
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

                        if(btn == 0)
                            openHomePage();
                        else
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
