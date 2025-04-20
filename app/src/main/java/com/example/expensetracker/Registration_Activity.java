package com.example.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class Registration_Activity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPass;
    private Button btnReg;
    private TextView mSignin;
    private EditText mCnfPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registration();
    }

    private void registration(){

        mEmail=findViewById(R.id.email_signup);
        mPass=findViewById(R.id.password_signup);
        mSignin=findViewById(R.id.signin_reg);
        mCnfPass=findViewById(R.id.password_signup_confirm);
        btnReg=findViewById(R.id.btn_login);


        btnReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String email=mEmail.getText().toString().trim();
                String pass=mPass.getText().toString().trim();
                String cnfpass=mCnfPass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email Required!!");
                    return;
                }

                if(TextUtils.isEmpty(pass)){
                    mPass.setError("Password Required!!");

                }

                if(TextUtils.isEmpty(cnfpass)){
                    mCnfPass.setError("Confirm your Password!!");

                }



            }
        });

        mSignin.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               startActivity(new Intent(getApplicationContext(),MainActivity.class));
           }
        });

    }


}
