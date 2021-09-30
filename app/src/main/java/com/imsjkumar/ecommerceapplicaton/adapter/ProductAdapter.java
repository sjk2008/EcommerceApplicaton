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
import com.imsjkumar.ecommerceapplicaton.HomeActivity;
import com.imsjkumar.ecommerceapplicaton.MainActivity;
import com.imsjkumar.ecommerceapplicaton.R;
import com.imsjkumar.ecommerceapplicaton.model.MainModel;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<MainModel> list;

//    public ProductAdapter(Context context) {
//        this.context = context;
//    }



    Context context;

    public ProductAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MainModel model = list.get(position);
        holder.productIMG.setImageResource(model.getImage());
        holder.description.setText(model.getDescription());
        holder.priceTV.setText(model.getPrice());
        holder.productNameTV.setText(model.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("price",model.getPrice());
                intent.putExtra("desc",model.getDescription());
                intent.putExtra("name",model.getName());
                intent.putExtra("type",1);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productNameTV, priceTV, description;
        ImageView productIMG;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productIMG = itemView.findViewById(R.id.productIMG);

            productNameTV = itemView.findViewById(R.id.productNameTV);
            priceTV = itemView.findViewById(R.id.priceTV);
            description = itemView.findViewById(R.id.descriptionTV);

        }
    }
}
