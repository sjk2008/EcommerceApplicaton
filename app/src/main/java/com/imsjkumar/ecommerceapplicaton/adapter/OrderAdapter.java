package com.imsjkumar.ecommerceapplicaton.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imsjkumar.ecommerceapplicaton.DetailActivity;
import com.imsjkumar.ecommerceapplicaton.OrderActivity;
import com.imsjkumar.ecommerceapplicaton.R;
import com.imsjkumar.ecommerceapplicaton.model.OrderModel;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    ArrayList<OrderModel> orderModelArrayList ;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> orderModelArrayList,Context context) {
        this.orderModelArrayList = orderModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OrderModel orderModel = orderModelArrayList.get(position);
        holder.orderproductNameTV.setText(orderModel.getOrderproductName());
        holder.orderIMG.setImageResource(orderModel.getOrderImage());
       holder.orderedpriceTV.setText(orderModel.getPrice());
        holder.ordernumberTV.setText(orderModel.getOrderNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", orderModel.getOrderNumber());
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView orderIMG;
        TextView orderproductNameTV,orderedpriceTV,ordernumberTV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            orderIMG = itemView.findViewById(R.id.orderIMG);
            orderproductNameTV = itemView.findViewById(R.id.orderproductNameTV);
            orderedpriceTV = itemView.findViewById(R.id.orderpriceTV);
            ordernumberTV= itemView.findViewById(R.id.orderNumberTV);
        }
    }
}
