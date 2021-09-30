package com.imsjkumar.ecommerceapplicaton;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.imsjkumar.ecommerceapplicaton.databinding.ActivityDetailBinding;
import com.imsjkumar.ecommerceapplicaton.sqlite.DBHelper;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());
//        int price = Integer.parseInt(getIntent().getStringExtra("price"));

        DBHelper myDB = new DBHelper(this);
        if (true) {

            int image = getIntent().getIntExtra("image", 0);
            String price = getIntent().getStringExtra("price");
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");


            activityDetailBinding.orderedIMG.setImageResource(image);
            activityDetailBinding.orderdescriptionTV.setText(description);
            activityDetailBinding.orderedNameTV.setText(name);
            activityDetailBinding.orderedPriceTV.setText(price);


            activityDetailBinding.orderNowBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = myDB.insertOrder(activityDetailBinding.nameTV.getText().toString(),
                            activityDetailBinding.phoneTV.getText().toString(),
                            Integer.parseInt(activityDetailBinding.countTV.getText().toString()),
                            activityDetailBinding.orderedPriceTV.getText().toString(),
                            image
                    );

                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Order Not Placed", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            int id =  getIntent().getIntExtra("id",0);
            Cursor cursor = myDB.getOrderById(id);

            int image = cursor.getInt(4);
            activityDetailBinding.orderedIMG.setImageResource(image);
            activityDetailBinding.orderedPriceTV.setText(String.format("%d",cursor.getInt(3)));
//            activityDetailBinding.orderedNameTV.setText(cursor.getString(6));
            activityDetailBinding.countTV.setText(cursor.getInt(5));

            activityDetailBinding.nameTV.setText(cursor.getString(1));
            activityDetailBinding.phoneTV.setText(cursor.getString(2));
            activityDetailBinding.orderNowBTN.setText("Update Now");
            activityDetailBinding.orderNowBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isUpdated = myDB.updateOrder(
                            activityDetailBinding.nameTV.getText().toString(),
                            activityDetailBinding.phoneTV.getText().toString(),
                            image,
                            Integer.parseInt(activityDetailBinding.orderedPriceTV.getText().toString()),
                            activityDetailBinding.orderedNameTV.getText().toString(),
                            1,
                            id
                    );

                    if (isUpdated)
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
//            activityDetailBinding.orderdescriptionTV.setText(cursor.getString());
        }
    }
}