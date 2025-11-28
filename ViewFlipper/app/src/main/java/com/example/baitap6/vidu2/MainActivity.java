package com.example.baitap6.vidu2;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.baitap6.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private List<Images> imagesList;
    private Handler handler = new Handler();
    private Runnable runable = new Runnable() {
        @Override
        public void run() {
            if(viewPager.getCurrentItem() == imagesList.size() - 1){
                viewPager.setCurrentItem(0);
            }else{
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpage);
        circleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator);
        imagesList = getListImages();
        ImagesViewPageAdapter adapter = new ImagesViewPageAdapter(imagesList);


        handler.postDelayed(runable, 3000);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runable);
                handler.postDelayed(runable, 3000);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
    }
    private List<Images> getListImages(){
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.img));
        list.add(new Images(R.drawable.img_1));
        list.add(new Images(R.drawable.img_2));
        list.add(new Images(R.drawable.img_3));
        return list;
    }
    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runable);
    }
    @Override
    protected void onResume(){
        super.onResume();
        handler.postDelayed(runable, 3000);
    }
}