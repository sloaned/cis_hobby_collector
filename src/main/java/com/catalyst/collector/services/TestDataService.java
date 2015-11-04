package com.catalyst.collector.services;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Keyword;
import com.catalyst.collector.entities.TestData;

public interface TestDataService {

    public ArrayList<Keyword> getAllKeywords();
    public boolean addKeyword(Keyword keyword);
    public Keyword getKeyword(Integer id);
}
