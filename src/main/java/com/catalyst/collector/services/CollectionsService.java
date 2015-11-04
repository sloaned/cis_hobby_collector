package com.catalyst.collector.services;

import java.util.ArrayList;

import com.catalyst.collector.entities.Keyword;

public interface CollectionsService {

    public ArrayList<Keyword> getAllKeywords();
    public boolean addKeyword(Keyword keyword);
    public boolean updateKeyword(Keyword keyword);
    public void removeKeyword(Integer id);
}
