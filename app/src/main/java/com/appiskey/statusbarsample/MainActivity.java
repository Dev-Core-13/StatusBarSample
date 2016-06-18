package com.appiskey.statusbarsample;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.appiskey.statusbarsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        actionBar = getSupportActionBar();

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActionBar();
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideActionBar();
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStatusBar();
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideStatusBar();
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentBehindStatusBar();
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unsetContentBehindStatusBar();
            }
        });


    }

    public void hideActionBar() {
        if (actionBar == null) {
            actionBar = getSupportActionBar();
        }
        assert actionBar != null;
        actionBar.hide();
    }

    public void showActionBar() {
        if (actionBar == null) {
            actionBar = getSupportActionBar();
        }
        assert actionBar != null;
        actionBar.show();
    }

    public void showStatusBar() {

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            // Show Status Bar.
            int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
            decorView.setSystemUiVisibility(uiOptions);
        }

    }

    public void hideStatusBar() {

        // Hide Status Bar
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            // Hide Status Bar.
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    public void setContentBehindStatusBar() {
        if (Build.VERSION.SDK_INT > 16) {
            View decorView = getWindow().getDecorView();
            // Hide Status Bar.
            int uiOptions =
//                      View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                      |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

    }

    public void unsetContentBehindStatusBar() {
        if (Build.VERSION.SDK_INT > 16) {
            View decorView = getWindow().getDecorView();
            // Hide Status Bar.
            int uiOptions =
//                     View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    ;
            decorView.setSystemUiVisibility(uiOptions);
        }

    }

}