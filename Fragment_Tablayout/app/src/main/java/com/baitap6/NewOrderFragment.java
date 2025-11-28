package com.baitap6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

// Import đúng binding của package com.baitap6
import com.baitap6.databinding.FragmentNeworderBinding;

public class NewOrderFragment extends Fragment {

    private FragmentNeworderBinding binding;

    public NewOrderFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNeworderBinding.inflate(inflater, container, false);
        binding.tvTitle.setText("Danh sách đơn hàng mới");
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}