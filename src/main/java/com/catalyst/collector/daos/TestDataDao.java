package com.catalyst.collector.daos;

import java.util.ArrayList;

import com.catalyst.collector.entities.Keyword;

public interface TestDataDao {

    public ArrayList<Keyword> getAllKeywords();
    public void addKeyword(Keyword keyword);
    public Keyword getKeyword(Integer id);
    public void removeKeyword(Integer id);
}
