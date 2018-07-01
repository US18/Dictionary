package com.example.uplabdhisingh.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

public class AddWords extends AppCompatActivity
{

    EditText wordTitleEditText, wordDescEditText, wordSynAntEditText;
    Button addWordsButton;
    String wordTitle, wordDesc, wordSynAnt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_words);

        Parse.initialize(this);

        wordTitleEditText = (EditText) findViewById(R.id.et_word_title);
        wordDescEditText = (EditText) findViewById(R.id.et_word_meaning);
        wordSynAntEditText = (EditText) findViewById(R.id.et_word_syn_ant);
        addWordsButton = (Button) findViewById(R.id.add_button);

        
        addWordsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                wordTitle = wordTitleEditText.getText().toString();
                wordDesc = wordDescEditText.getText().toString();
                wordSynAnt = wordSynAntEditText.getText().toString();

                ParseObject dbObject = new ParseObject("WordsDatabase");
                dbObject.put("WORD_TITLE", wordTitle);
                dbObject.put("WORD_CONTENT",wordDesc);
                dbObject.put("WORD_SYN_ANT",wordSynAnt);
                dbObject.saveInBackground();

                Toast.makeText(AddWords.this, "Word Added!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
