package com.example.uplabdhisingh.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminAccess extends AppCompatActivity
{

    Button addButton, updateButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_access);

        addButton = (Button) findViewById(R.id.btn_add_words);
        updateButton = (Button) findViewById(R.id.btn_update_words);
        deleteButton = (Button) findViewById(R.id.btn_delete_words);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToAddWords = new Intent(AdminAccess.this, AddWords.class);
                startActivity(intentToAddWords);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToUpdateWords = new Intent(AdminAccess.this,UpdateWords.class);
                startActivity(intentToUpdateWords);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToDeleteWords = new Intent(AdminAccess.this, DeleteWords.class);
                startActivity(intentToDeleteWords);
            }
        });

    }
}
