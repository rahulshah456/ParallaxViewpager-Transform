package com.droid2developer.india.ParallaxViewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import Adapter.SlideShowAdapter;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private SlideShowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarID);
        toolbar.setTitle("Parallax Slide Show");
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPagerID);

        adapter = new  SlideShowAdapter (this);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                if (position <= -1 || position >= 1){
                    page.findViewById(R.id.imageViewID).setVisibility(View.VISIBLE);
                }
                else if( position == 0) {
                    page.findViewById(R.id.imageViewID).setVisibility(View.VISIBLE);
                } else {
                    page.findViewById(R.id.imageViewID).setTranslationX(-position * page.getWidth() / 2);
                    //Use this to add white shadow while sliding
                    //page.setAlpha(1.0f - Math.abs(position));
                }
            }
        });


    }
}
