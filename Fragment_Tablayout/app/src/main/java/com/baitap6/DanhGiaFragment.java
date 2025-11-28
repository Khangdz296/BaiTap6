package com.baitap6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.baitap6.databinding.FragmentDanhgiaBinding;

public class DanhGiaFragment extends Fragment {
    private FragmentDanhgiaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDanhgiaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}