package com.s21v.cpdnews_for_android6x.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import com.s21v.cpdnews_for_android6x.R;
import com.s21v.cpdnews_for_android6x.adapter.Splash_ViewPagerAdapter;
import com.s21v.cpdnews_for_android6x.utils.Constant;
import java.util.ArrayList;

/**
 * Splash界面,只在应用第一次打开时显示
 * Created by 弈 on 2015/11/2.
 */
public class SplashActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private int[] imageIDs;
    private ArrayList<ImageView> imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initDate();
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.id_viewPager);
        imageViews = new ArrayList<>(Constant.DOT_SIZE);
        imageViews.add((ImageView) findViewById(R.id.id_dot_image1));
        imageViews.add((ImageView) findViewById(R.id.id_dot_image2));
        imageViews.add((ImageView) findViewById(R.id.id_dot_image3));
        viewPager.setAdapter(new Splash_ViewPagerAdapter(getSupportFragmentManager(),imageIDs));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int currentPosition = 0;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                imageViews.get(currentPosition).setSelected(false);
                currentPosition = position;
                imageViews.get(currentPosition).setSelected(true);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initDate() {
        Class img = com.s21v.cpdnews_for_android6x.R.drawable.class;
        imageIDs = new int[Constant.DOT_SIZE];
        for(int i=0; i<Constant.DOT_SIZE; i++) {
            try {
                imageIDs[i] = img.getDeclaredField("slide_demo"+(i+1)).getInt(this);
            } catch (Exception e) {
                Log.e("initDate()",e.getLocalizedMessage());
            }
        }
    }
}
