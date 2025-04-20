package com.example.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPass;
    private EditText btnLogin;
    private TextView mForgetPassword;
    private TextView mSignupHere;
    private EditText mCnfPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LoginDetails();


    }

    private void LoginDetails(){
            mEmail=findViewById(R.id.email_login);
            mPass=findViewById(R.id.password_login);
            btnLogin=findViewById(R.id.btn_login);
            mForgetPassword=findViewById(R.id.forget_password);
            mSignupHere=findViewById(R.id.signup_reg);

            btnLogin.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    String email=mEmail.getText().toString().trim();
                    String pass=mPass.getText().toString().trim();
                    String cnfpass=mCnfPass.getText().toString().trim();

                    if(TextUtils.isEmpty(email)){
                        mEmail.setError("Email Required!!!");
                        return;
                    }

                    if(TextUtils.isEmpty(pass)){
                        mPass.setError("Password Required!!!");
                        return;
                    }

                    if(TextUtils.isEmpty(cnfpass)){
                        mCnfPass.setError("Enter the password again!!!");
                        return;
                    }

                }
            });

            //Registration activity

            mSignupHere.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View view){
                   startActivity(new Intent(getApplicationContext(),Registration_Activity.class));
                }
            });

            //Reset password activity

        mForgetPassword.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View view){
               startActivity(new Intent(getApplicationContext(),Reset_Activity.class));
           }
        });

    }

}