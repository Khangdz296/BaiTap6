package com.example.baitap6.baitap;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.baitap6.R;
import com.example.baitap6.vidu2.Images;
import com.example.baitap6.vidu2.ImagesViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;

public class ImageActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Images> imagesList;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(viewPager2.getCurrentItem() == imagesList.size() - 1){
                viewPager2.setCurrentItem(0);
            }else{
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }

        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        viewPager2 = (ViewPager2) findViewById(R.id.viewpage2);
        circleIndicator3 = (CircleIndicator3) findViewById(R.id.circle_indicator3);
        imagesList = getListImages();
        ImagesViewPager2Adapter adapter = new ImagesViewPager2Adapter(imagesList);
        viewPager2.setAdapter(adapter);
        circleIndicator3.setViewPager(viewPager2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000); // delay 3s
            }
        });

        viewPager2.setPageTransformer(new DepthPageTransformer());

    }

    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.img));
        list.add(new Images(R.drawable.img_1));
        list.add(new Images(R.drawable.img_2));
        list.add(new Images(R.drawable.img_3));
        return list;
    }
}
