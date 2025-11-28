package com.baitap6_1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcIcon;
    private IconAdapter iconAdapter;
    private List<IconModel> arrayList1;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcIcon = findViewById(R.id.rclIcon);
        searchView = findViewById(R.id.searchView);

        arrayList1 = new ArrayList<>();
        arrayList1.add(new IconModel(R.drawable.pizza, "Pizza Ngon"));
        arrayList1.add(new IconModel(R.drawable.pop_1, "Combo 1"));
        arrayList1.add(new IconModel(R.drawable.pop_2, "Combo 2"));
        arrayList1.add(new IconModel(R.drawable.pop_3, "Combo 3"));
        arrayList1.add(new IconModel(R.drawable.logo, "Logo Quán"));
        arrayList1.add(new IconModel(R.drawable.pizza, "Pizza Ngon"));
        arrayList1.add(new IconModel(R.drawable.pop_1, "Combo 1"));
        arrayList1.add(new IconModel(R.drawable.pop_2, "Combo 2"));
        arrayList1.add(new IconModel(R.drawable.pop_3, "Combo 3"));
        arrayList1.add(new IconModel(R.drawable.logo, "Logo Quán"));
        arrayList1.add(new IconModel(R.drawable.pizza, "Pizza Ngon"));
        arrayList1.add(new IconModel(R.drawable.pop_1, "Combo 1"));
        arrayList1.add(new IconModel(R.drawable.pop_2, "Combo 2"));
        arrayList1.add(new IconModel(R.drawable.pop_3, "Combo 3"));
        arrayList1.add(new IconModel(R.drawable.logo, "Logo Quán"));
        arrayList1.add(new IconModel(R.drawable.pizza, "Pizza Ngon"));
        arrayList1.add(new IconModel(R.drawable.pop_1, "Combo 1"));
        arrayList1.add(new IconModel(R.drawable.pop_2, "Combo 2"));
        arrayList1.add(new IconModel(R.drawable.pop_3, "Combo 3"));
        arrayList1.add(new IconModel(R.drawable.logo, "Logo Quán"));
        arrayList1.add(new IconModel(R.drawable.pizza, "Pizza Ngon"));
        arrayList1.add(new IconModel(R.drawable.pop_1, "Combo 1"));
        arrayList1.add(new IconModel(R.drawable.pop_2, "Combo 2"));
        arrayList1.add(new IconModel(R.drawable.pop_3, "Combo 3"));
        arrayList1.add(new IconModel(R.drawable.logo, "Logo Quán"));
        arrayList1.add(new IconModel(R.drawable.pizza, "Pizza Ngon"));
        arrayList1.add(new IconModel(R.drawable.pop_1, "Combo 1"));
        arrayList1.add(new IconModel(R.drawable.pop_2, "Combo 2"));
        arrayList1.add(new IconModel(R.drawable.pop_3, "Combo 3"));
        arrayList1.add(new IconModel(R.drawable.logo, "Logo Quán"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);

        iconAdapter = new IconAdapter(this, arrayList1);
        rcIcon.setAdapter(iconAdapter);

        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration());


        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });
    }

    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();
        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                list.add(iconModel);
            }
        }

        if (list.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            iconAdapter.setListenerList(list);
        }
    }
}