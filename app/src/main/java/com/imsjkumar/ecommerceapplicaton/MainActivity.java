package com.imsjkumar.ecommerceapplicaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imsjkumar.ecommerceapplicaton.sqlite.DBHelper;

public class MainActivity extends AppCompatActivity {
    private Button signUpBTN, signInBTN;
    private EditText username, passwordEDT, repasswprdEDT;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        passwordEDT = findViewById(R.id.passwordEDT);
        repasswprdEDT = findViewById(R.id.reEnterPassword);

        signUpBTN = findViewById(R.id.signUpBTN);
        signInBTN = findViewById(R.id.signINBTN);

        myDB = new DBHelper(this);

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = passwordEDT.getText().toString();
                String repass = repasswprdEDT.getText().toString();
                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill alll the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean usercheckResult = myDB.checkusername(user);
                        if (usercheckResult == false) {
                            Boolean regResult = myDB.insertData(user, pass);

                            if (regResult == true) {
                                Toast.makeText(MainActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(MainActivity.this, "Not Registered", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "User Already Exists \n Please Sign In ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Password not matched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signInBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}