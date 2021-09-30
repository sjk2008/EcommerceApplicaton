package com.imsjkumar.ecommerceapplicaton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.imsjkumar.ecommerceapplicaton.adapter.OrderAdapter;
import com.imsjkumar.ecommerceapplicaton.databinding.ActivityHomeBinding;
import com.imsjkumar.ecommerceapplicaton.databinding.ActivityOrderBinding;
import com.imsjkumar.ecommerceapplicaton.model.MainModel;
import com.imsjkumar.ecommerceapplicaton.model.OrderModel;
import com.imsjkumar.ecommerceapplicaton.sqlite.DBHelper;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding activityOrderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityOrderBinding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(activityOrderBinding.getRoot());

//        ArrayList<OrderModel>orderModels = new ArrayList<>();
//        orderModels.add(new OrderModel(R.drawable.cooler, "Laptop Cooler", "₹ 900", "1234567"));
//        orderModels.add(new OrderModel(R.drawable.hair, "Dryer", "₹ 800", "1234568"));
//        orderModels.add(new OrderModel(R.drawable.keyboard, "Keyboard And Mouse", "₹ 1500", "1234569"));
//        orderModels.add(new OrderModel(R.drawable.samsung, "Samsung", "₹ 32,000", "12345610"));
//        orderModels.add(new OrderModel(R.drawable.trimmer, "Trimmer", "₹ 500", "12345611"));


//        DBHelper myDB =new DBHelper(this);
//        ArrayList<OrderModel> orderModels =myDB.getOrders();
        DBHelper helper = new DBHelper(this);
        ArrayList<OrderModel> orderModels = helper.getOrders();

        OrderAdapter orderAdapter = new OrderAdapter(orderModels, this);
        activityOrderBinding.orderRV.setAdapter(orderAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        activityOrderBinding.orderRV.setLayoutManager(linearLayoutManager);
    }
}