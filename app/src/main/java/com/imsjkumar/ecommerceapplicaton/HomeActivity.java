package com.imsjkumar.ecommerceapplicaton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.imsjkumar.ecommerceapplicaton.adapter.ProductAdapter;
import com.imsjkumar.ecommerceapplicaton.databinding.ActivityHomeBinding;
import com.imsjkumar.ecommerceapplicaton.model.MainModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.cooler, "Laptop Cooler", "₹ 900", "Helps to reduce the hot air"));
        list.add(new MainModel(R.drawable.hair, "Dryer", "₹ 800", "Make your hair cool"));
        list.add(new MainModel(R.drawable.keyboard, "Keyboard And Mouse", "₹ 1500", "External Keyboard and Mouse "));
        list.add(new MainModel(R.drawable.samsung, "Samsung", "₹ 32,000", "Best SmartPhone by samsung"));
        list.add(new MainModel(R.drawable.trimmer, "Trimmer", "₹ 500", "Groom yourself"));
        list.add(new MainModel(R.drawable.cooler, "Laptop Cooler", "₹ 900", "Helps to reduce the hot air"));
        list.add(new MainModel(R.drawable.hair, "Dryer", "₹ 800", "Make your hair cool"));
        list.add(new MainModel(R.drawable.keyboard, "Keyboard And Mouse", "₹ 1500", "External Keyboard and Mouse "));
        list.add(new MainModel(R.drawable.samsung, "Samsung", "₹ 32,000", "Best SmartPhone by samsung"));
        list.add(new MainModel(R.drawable.trimmer, "Trimmer", "₹ 500", "Groom yourself"));
        list.add(new MainModel(R.drawable.cooler, "Laptop Cooler", "₹ 900", "Helps to reduce the hot air"));
        list.add(new MainModel(R.drawable.hair, "Dryer", "₹ 800", "Make your hair cool"));
        list.add(new MainModel(R.drawable.keyboard, "Keyboard And Mouse", "₹ 1500", "External Keyboard and Mouse "));
        list.add(new MainModel(R.drawable.samsung, "Samsung", "₹ 32,000", "Best SmartPhone by samsung"));
        list.add(new MainModel(R.drawable.trimmer, "Trimmer", "₹ 500", "Groom yourself"));
        list.add(new MainModel(R.drawable.cooler, "Laptop Cooler", "₹ 900", "Helps to reduce the hot air"));
        list.add(new MainModel(R.drawable.hair, "Dryer", "₹ 800", "Make your hair cool"));
        list.add(new MainModel(R.drawable.keyboard, "Keyboard And Mouse", "₹ 1500", "External Keyboard and Mouse "));
        list.add(new MainModel(R.drawable.samsung, "Samsung", "₹ 32,000", "Best SmartPhone by samsung"));
        list.add(new MainModel(R.drawable.trimmer, "Trimmer", "₹ 500", "Groom yourself"));

        ProductAdapter productAdapter = new ProductAdapter(list, this);
        binding.commerceRV.setAdapter(productAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.commerceRV.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.order:
                startActivity(new Intent(HomeActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}