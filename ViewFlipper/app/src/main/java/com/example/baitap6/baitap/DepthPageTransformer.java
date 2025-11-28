package com.example.baitap6.baitap;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

public class DepthPageTransformer implements ViewPager2.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) {   // [-Infinity, -1)
            // Trang này nằm ngoài màn hình bên trái
            view.setAlpha(0f);

        } else if (position <= 0) {   // [-1, 0]
            // Sử dụng hiệu ứng mặc định khi kéo qua trái
            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setTranslationZ(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);

        } else if (position <= 1) {   // (0, 1]
            // Mờ dần trang
            view.setAlpha(1 - position);

            // Chống lại hiệu ứng slide mặc định
            view.setTranslationX(pageWidth * -position);

            // Đẩy trang ra phía sau
            view.setTranslationZ(-1f);

            // Thu nhỏ trang (từ MIN_SCALE → 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else {    // (1, +Infinity]
            // Trang ngoài màn hình bên phải
            view.setAlpha(0f);
        }
    }
}

