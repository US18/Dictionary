package com.example.uplabdhisingh.dictionary;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uplabdhisingh.dictionary.model.Words;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    AutoCompleteTextView wordSearchAutoTextView;
    Button searchButton;

    ArrayList<String> arrayWords;
    ArrayAdapter<String> adapter;

    String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this);

        wordSearchAutoTextView = (AutoCompleteTextView) findViewById(R.id.actv_word_search);
        searchButton = (Button) findViewById(R.id.btn_search);

        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, arrayWords);
        
        wordSearchAutoTextView.setThreshold(1);
        wordSearchAutoTextView.setAdapter(adapter);
        wordSearchAutoTextView.setTextColor(Color.RED);

        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intentToDescActivity = new Intent(MainActivity.this,WordDescActivity.class);
                startActivity(intentToDescActivity);
            }
        });
        refreshList();
    }

    private void refreshList()
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("WordsDatabase");
        query.findInBackground(new FindCallback<ParseObject>()
        {
            @Override
            public void done(List<ParseObject> parseObjectList, ParseException e)
            {
                arrayWords = new ArrayList<String>();
                if(e == null)
                {
                    for(int i = 0; i < parseObjectList.size() ; i++)
                    {
                        String titleFromDb = parseObjectList.get(i).getString("WORD_TITLE");
                        arrayWords.add(titleFromDb);
                    }
                    Log.d(TAG,"MESSAGE IS : "+arrayWords.size()+"\n");

                } else {
                    Log.d(TAG,"ERROR MESSAGE IS : "+e.getMessage()+"\n");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int itemID = item.getItemId();
        if(itemID == R.id.item_admin)
        {
            Intent intentToAdminLogin = new Intent(MainActivity.this, AdminLoginForm.class);
            startActivity(intentToAdminLogin);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
