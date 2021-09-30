package com.imsjkumar.ecommerceapplicaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imsjkumar.ecommerceapplicaton.sqlite.DBHelper;

public class LogInActivity extends AppCompatActivity {
    private EditText username, password;
    private Button loginBTN;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        username = findViewById(R.id.usernameLogIn);
        password = findViewById(R.id.passwordLogin);
        loginBTN = findViewById(R.id.LoginBTN);

        myDB = new DBHelper(this);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(LogInActivity.this, "Please Enter the Credential", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean result = myDB.checkUsernamepassword(user, pass);
                    if (result == true) {
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LogInActivity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}