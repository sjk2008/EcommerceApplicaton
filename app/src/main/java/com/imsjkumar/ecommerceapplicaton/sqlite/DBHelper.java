package com.imsjkumar.ecommerceapplicaton.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.imsjkumar.ecommerceapplicaton.model.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        //Create the table
        myDB.execSQL("create Table orders (id integer primary key,name Text, phone Text , " +
                "image integer ,quantity integer,price integer)");
//        myDB.execSQL("create Table orders" +
//                "(id integer primary key autoincrement," +
//                "name text, " +
//                "phone text," +
//                "image int," +
//                "quantity int," +
//                "price int," +
//                "food text)");

        myDB.execSQL("create Table users (username Text primary key , password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        //Upgrade
        myDB.execSQL("drop Table if exists users");
//        onCreate(myDB);
    }

    public Boolean insertOrder(String name, String phone, int quantity, String price, int image) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("price", Integer.parseInt(price.substring(2,price.length())));
        contentValues.put("image", image);
        contentValues.put("quantity", quantity);
        long id = myDB.insert("orders", null, contentValues);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean updateOrder(String name, String phone, int i, int quantity, String price, int image, int id) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("price", Integer.parseInt(price));
        contentValues.put("image", image);
        contentValues.put("quantity", quantity);
        long row = myDB.update("orders",contentValues,"id"+id,null);
        if (row <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean insertData(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<OrderModel> getOrders() {
        ArrayList<OrderModel> orders = new ArrayList<>();
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select id , name,image,price from orders", null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrderModel model = new OrderModel();
                model.setOrderNumber(cursor.getInt(0) + "");
                model.setOrderproductName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        myDB.close();
        return orders;
    }

    public Cursor getOrderById(int id){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from orders where id  =  "+id, null);

        if (cursor != null)
            cursor.moveToFirst();

        return cursor;
    }

    public Boolean checkusername(String username) {

        //this method will check the user either the user is already register or not
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? ", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUsernamepassword(String username, String password) {

        //this method is called whenever the login button is clicked
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?  and password =?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


}
