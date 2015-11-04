package com.catalyst.collector.daos;

import java.util.ArrayList;

import com.catalyst.collector.entities.Keyword;

public interface CollectionsDao {

    public ArrayList<Keyword> getAllKeywords();
    public void addKeyword(Keyword keyword);
    public void updateKeyword(Keyword keyword);
    public void removeKeyword(Integer id);
}
