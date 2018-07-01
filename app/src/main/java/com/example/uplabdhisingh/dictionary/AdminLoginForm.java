package com.example.uplabdhisingh.dictionary;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class AdminLoginForm extends AppCompatActivity
{

    EditText usernameEditText, passwordEditText;
    Button signInButton;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_form);

        Parse.initialize(this);

        signInButton = (Button) findViewById(R.id.btn_sign_in);
        usernameEditText = (EditText) findViewById(R.id.et_username);
        passwordEditText = (EditText) findViewById(R.id.et_password);


        /*
        * username : admin
        * password : admin@123
        * */

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                progressDialog = new ProgressDialog(AdminLoginForm.this);

                progressDialog.setMessage("Please Wait while we get you Logged In...");
                progressDialog.setTitle("Logging In");
                progressDialog.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            parseLogin();

                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }).start();




            }
        });
    }

    void parseLogin()
    {
        ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(),
                new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null)
                        {
                            progressDialog.dismiss();
                            alertDisplayer("Login Successful", "Welcome " +user.getUsername());

                            Intent intentToAdminAccess = new Intent(AdminLoginForm.this, AdminAccess.class);
                            startActivity(intentToAdminAccess);

                        }
                        else {
                            progressDialog.dismiss();
                            alertDisplayer("Login Failed!", e.getMessage()+" Please Try Again.");
                        }
                    }
                });
    }

    void alertDisplayer(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(AdminLoginForm.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Ok ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }

}
