package com.root.ashad.appmaker.addd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MainActivity extends AppCompatActivity {
    private Button mShowVideoButton;
    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowVideoButton = ((Button) findViewById(R.id.watch_video));


        // Initialize the Google Mobile Ads SDK
        MobileAds.initialize(getApplicationContext(),
                getString(R.string.admob_app_id));

        // Get reference to singleton RewardedVideoAd object
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);


        // Load a reward based video ad
        mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());



    }


    public void showRewardedVideo(View view) {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"not loaded yet",Toast.LENGTH_SHORT).show();
        }
    }



}
