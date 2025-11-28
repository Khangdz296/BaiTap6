package com.example.baitap6.vidu1;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.baitap6.R;

import java.util.ArrayList;
import java.util.List;

public class ViewFlipperActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewflipper);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipperMain);
        ActionViewFlipperMain();
    }

    private void ActionViewFlipperMain(){
        List<String> arrayListFlipper = new ArrayList<>();
        arrayListFlipper.add("http://app.iotstar.vn:8081/appfoods/flipper/quangcao.png");
        arrayListFlipper.add("http://app.iotstar.vn:8081/appfoods/flipper/coffee.jpg");
        arrayListFlipper.add("http://app.iotstar.vn:8081/appfoods/flipper/companypizza.jpeg");
        arrayListFlipper.add("http://app.iotstar.vn:8081/appfoods/flipper/themoingon.jpeg");
        for(int i=0; i<arrayListFlipper.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(arrayListFlipper.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }
}
