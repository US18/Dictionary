package com.example.uplabdhisingh.dictionary.model;

public class Words
{
    String id, word_title, word_content, word_syn_ant;

    public Words(String id, String word_title, String word_content, String word_syn_ant)
    {

        this.id=id;
        this.word_title=word_title;
        this.word_content=word_content;
        this.word_syn_ant=word_syn_ant;

    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id=id;
    }

    public String getTitle()
    {
        return word_title;
    }

    public void setTitle(String word_title)
    {
        this.word_title=word_title;
    }

    public String getContent()
    {
        return word_content;
    }

    public void setContent(String word_content)
    {
        this.word_content = word_content;
    }

    public String getSynAnt()
    {
        return word_syn_ant;
    }

    public void setWord_syn_ant(String word_syn_ant)
    {
        this.word_syn_ant=word_syn_ant;
    }

    @Override
    public String toString()
    {
        return this.getTitle();
    }
}
