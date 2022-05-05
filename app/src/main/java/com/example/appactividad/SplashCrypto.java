package com.example.appactividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashCrypto extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY=2500;

    Animation crypto;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_crypto);

        String nameCrypto = getIntent().getStringExtra("name");
        //Animacion
        crypto = AnimationUtils.loadAnimation(this,R.anim.crypto);
        img = findViewById(R.id.img);

        if (nameCrypto.equals("BNB")){
            img.setBackgroundResource(R.drawable.bnb);
            img.setAnimation(crypto);
        } else if (nameCrypto.equals("AVAX")) {
            img.setBackgroundResource(R.drawable.avax);
            img.setAnimation(crypto);
        } else if (nameCrypto.equals("ATOM")) {
            img.setBackgroundResource(R.drawable.atom);
            img.setAnimation(crypto);
        } else if (nameCrypto.equals("ADA")) {
            img.setBackgroundResource(R.drawable.ada);
            img.setAnimation(crypto);
        } else if (nameCrypto.equals("XTZ")) {
            img.setBackgroundResource(R.drawable.xtz);
            img.setAnimation(crypto);
        } else if (nameCrypto.equals("BTC")) {
            img.setBackgroundResource(R.drawable.btc);
            img.setAnimation(crypto);
        } else if (nameCrypto.equals("ETH")) {
            img.setBackgroundResource(R.drawable.eth);
            img.setAnimation(crypto);
        } else if (nameCrypto.equals("EOS")) {
            img.setBackgroundResource(R.drawable.eos);
            img.setAnimation(crypto);
        } else if (nameCrypto.equals("RUNE")) {
            img.setBackgroundResource(R.drawable.rune);
            img.setAnimation(crypto);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nameCrypto.equals("BNB")){
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","BNB");
                    startActivity(intent);
                    finish();
                } else if (nameCrypto.equals("AVAX")) {
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","AVAX");
                    startActivity(intent);
                    finish();
                } else if (nameCrypto.equals("ATOM")) {
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","ATOM");
                    startActivity(intent);
                    finish();
                } else if (nameCrypto.equals("ADA")) {
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","ADA");
                    startActivity(intent);
                    finish();
                } else if (nameCrypto.equals("XTZ")) {
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","XTZ");
                    startActivity(intent);
                    finish();
                } else if (nameCrypto.equals("BTC")) {
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","BTC");
                    startActivity(intent);
                    finish();
                } else if (nameCrypto.equals("ETH")) {
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","ETH");
                    startActivity(intent);
                    finish();
                } else if (nameCrypto.equals("EOS")) {
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","EOS");
                    startActivity(intent);
                    finish();
                } else if (nameCrypto.equals("RUNE")) {
                    Intent intent = new Intent(SplashCrypto.this,bnb.class);
                    intent.putExtra("name","RUNE");
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_SCREEN_DELAY);
    }
}