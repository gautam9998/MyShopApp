package com.gautam.myshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity {
    private Button createAccountButton,verify;
     private EditText inputName,inputPassword,inputPhoneNumber,otp;
     private ProgressDialog loadingBar;
     private String mVerificationId;
     private PhoneAuthProvider.ForceResendingToken mResendToken;

     private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
     private FirebaseAuth mAuth;





     public String name,phone,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);





        mAuth=FirebaseAuth.getInstance();


        createAccountButton=(Button)findViewById(R.id.register_btn);
        verify=(Button)findViewById(R.id.verify_btn);
        inputName=findViewById(R.id.user_name_input);
        inputPassword=findViewById(R.id.register_password_input);
        inputPhoneNumber=findViewById(R.id.register_phone_number_input);
        loadingBar=new ProgressDialog(this);
        otp=findViewById(R.id.register_otp_input);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                name = inputName.getText().toString();
                phone = inputPhoneNumber.getText().toString();
                password = inputPassword.getText().toString();
                phone="+91"+phone;
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(RegisterActivity.this, "PLEASE PROVIDE YOUR NAME ...", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(RegisterActivity.this, "PLEASE PROVIDE YOUR PHONE NUMBER ...", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "PLEASE PROVIDE YOUR PASSWORD ...", Toast.LENGTH_LONG).show();
                } else
                    {


                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phone,        // Phone number to verify
                            60,                 // Timeout duration
                            TimeUnit.SECONDS,   // Unit of timeout
                            RegisterActivity.this,               // Activity (for callback binding)
                            callbacks);        // OnVerificationStateChangedCallbacks


//PhoneAuthProvider.getInstance().verifyPhoneNumber(phone,60,TimeUnit.SECONDS,RegisterActivity.this,callbacks);





               /*     loadingBar.setTitle("CREATE ACCOUNT");
                    loadingBar.setMessage("Please wait while creating your account ...");
                    loadingBar.setCanceledOnTouchOutside(false);
                    loadingBar.show();
                    ValidePhonenumber(name,phone,password);*/

                }
            }});










        callbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
            {


                signInWithPhoneAuthCredential(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e)
            {

                Toast.makeText(RegisterActivity.this,"Please Enter Valid Number ....",Toast.LENGTH_SHORT).show();




                inputName.setVisibility(View.VISIBLE);
                inputPassword.setVisibility(View.VISIBLE);
                inputPhoneNumber.setVisibility(View.VISIBLE);
                createAccountButton.setVisibility(View.VISIBLE);
                verify.setVisibility(View.INVISIBLE);
                otp.setVisibility(View.INVISIBLE);



            }





            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;
                Toast.makeText(RegisterActivity.this,"Code Sent",Toast.LENGTH_SHORT).show();



                inputName.setVisibility(View.INVISIBLE);
                inputPassword.setVisibility(View.INVISIBLE);
                inputPhoneNumber.setVisibility(View.INVISIBLE);
                createAccountButton.setVisibility(View.INVISIBLE);
                verify.setVisibility(View.VISIBLE);
                otp.setVisibility(View.VISIBLE);



                // ...
            }


        };











        verify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        inputName.setVisibility(View.INVISIBLE);
                        inputPassword.setVisibility(View.INVISIBLE);
                        inputPhoneNumber.setVisibility(View.INVISIBLE);
                        createAccountButton.setVisibility(View.INVISIBLE);
                        String verificationcode=otp.getText().toString();
                        if(TextUtils.isEmpty(verificationcode))
                        {
                            Toast.makeText(RegisterActivity.this,"Please write otp ...",Toast.LENGTH_SHORT).show();

                        }
                        else {
                            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, verificationcode);
                            signInWithPhoneAuthCredential(credential);
                        }

                    }
                });









    }






    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {



                            loadingBar.setTitle("CREATE ACCOUNT");
                            loadingBar.setMessage("Please wait while creating your account ...");
                            loadingBar.setCanceledOnTouchOutside(false);
                            loadingBar.show();
                            ValidePhonenumber(name,phone,password);














                        } else {

                        }
                    }
                });
    }



    private void ValidePhonenumber(final String name ,final String phone,final String password)
    {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.child("Users").child(phone).exists())
                {

                    HashMap userdataMap=new HashMap<>();
                    userdataMap.put("phone",phone);
                    userdataMap.put("password",password);
                    userdataMap.put("name",name);
                    RootRef.child("Users").child(phone).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {


                            if(task.isSuccessful())
                            {
                                Toast.makeText(RegisterActivity.this,"Account Created Successfully ...",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Intent intent= new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(RegisterActivity.this,"Error , try again ",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }

                        }
                    });

                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"This "+phone+" Is Already Registered",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this,"Try With New Number ...",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });








    }
}

