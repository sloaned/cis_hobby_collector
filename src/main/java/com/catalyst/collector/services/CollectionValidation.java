package com.catalyst.collector.services;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Keyword;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CollectionValidation {

    private Collectible collectible;
    private static final String keywordRegex = "[^a-zA-Z\\d]";
    private static final Pattern keywordPattern = Pattern.compile(keywordRegex);
    private Matcher matcher;

    public CollectionValidation(Collectible c) {
        collectible = c;
    }
    public boolean isCollectibleValid(){
        return isAgeValid() && isColorValid() && isKeywordsValid() && isConditionValid() && isCategoryValid();
    }

    private boolean isCategoryValid() {
        return isCategoryValid(collectible.getCategory().getCategory());
    }

    private boolean isConditionValid() {
        return isConditionValid(collectible.getCondition().getCondition());
    }

    private boolean isKeywordsValid() {
        for (Keyword k: collectible.getKeywords()) {
            if(!isKeywordValid(k.getKeyword()))
                return false;
        }
        return true;
    }

    private boolean isColorValid() {
        return isColorValid(collectible.getColor().getColor());
    }

    private boolean isAgeValid() {
        return isAgeValid(collectible.getAge().getAge());
    }

    static public boolean isAgeValid(String age){
        return (age != null && age.length() <= 255 && !age.matches(".*\\d.*") && !age.trim().equals(""));
         //Maximum of 255 characters for an age, no digits allowed

        }

    static public boolean isCategoryValid(String category){
        return !(category == null ||category.length() > 255 ||((category).trim()).equals("")|| category.matches(".*\\d.*"));
    }


    static public boolean isColorValid(String color){
        return !(color == null || color.trim().equals("") || color.length() > 255);
    }

    public boolean isKeywordValid(String keyword){
        if (keyword == null)
            return false;

        matcher = keywordPattern.matcher(keywordRegex);
        return !keyword.equals("") && keyword.length() < 256 && !matcher.find();
    }

    static public boolean isConditionValid(String condition){
        return !(condition == null || condition.equals("") || condition.length() > 255);
    }
}
