package com.gautam.myshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gautam.myshop.Model.Users;
import com.gautam.myshop.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

public class LoginActivity extends AppCompatActivity {
    private EditText phoneNumber,Password;
    private Button login;
    private CheckBox rememberme;
    private ProgressDialog loadingBar;
    private TextView AdminLink,NotAdminLink;



    private String parentDbname="Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Password=findViewById(R.id.login_password_input);
        phoneNumber=findViewById(R.id.login_phone_number_input);
        login=findViewById(R.id.login_btn);
        rememberme =findViewById(R.id.remember_me_chkb);
        Paper.init(this);
      AdminLink=findViewById(R.id.admin_panel_link);
        NotAdminLink=findViewById(R.id.not_admin_panel_link);
        loadingBar =new ProgressDialog(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });



        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbname="Admins";
            }
        });
        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbname="Users";
            }
        });
    }

    private void loginUser()
    {
        String phone =phoneNumber.getText().toString();
        String password =Password.getText().toString();

phone ="+91"+phone;
        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this,"PLEASE GIVE YOUR PHONE NUMBER ...",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"PLEASE GIVE YOUR PASSWORD ...",Toast.LENGTH_LONG).show();
        }
        else
        {
            loadingBar.setTitle("LOGIN ACCOUNT");
            loadingBar.setMessage("Please wait, while logging in your account ...");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccessToAccount(phone,password);
        }
    }
    private void AllowAccessToAccount(final String phone, final String password)
    {
        if(rememberme.isChecked())
        {
            Paper.book().write(Prevalent.UserPhoneKey,phone);
            Paper.book().write(Prevalent.UserPasswordKey,password);

         //   UserPhoneKey = Paper.book().read(Prevalent.UserPhoneKey);
          //  UserPasswordKey = Paper.book().read(Prevalent.UserPasswordKey);
        }


        //Toast.makeText(LoginActivity.this, "000000000", Toast.LENGTH_SHORT).show();

        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDbname).child(phone).exists())
                {
                    //Toast.makeText(LoginActivity.this, "1111111111", Toast.LENGTH_SHORT).show();

                    Users usersData=dataSnapshot.child(parentDbname).child(phone).getValue(Users.class);
                    if(usersData.getPhone().equals(phone)) {

                       // Toast.makeText(LoginActivity.this, "222222222", Toast.LENGTH_SHORT).show();

                        if (usersData.getPassword().equals(password))
                        {
                            if (parentDbname.equals("Admins"))
                            {
                                Toast.makeText(LoginActivity.this, "welcome admin Logged in Successfully ...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Intent intent = new Intent(LoginActivity.this, AdminAddNewProductActivity.class);
                                startActivity(intent);



                            }
                            else if (parentDbname.equals("Users"))
                            {
                                Toast.makeText(LoginActivity.this, "Logged in Successfully ...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }

                        } else
                            {
                                Toast.makeText(LoginActivity.this, "Login Failed,Incorrect Password ...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }

                    }

                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Account does not exist ...",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

