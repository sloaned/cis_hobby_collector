package com.catalyst.collector.services;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Keyword;

/**
 * Created by gstringfellow on 11/6/2015.
 */
public class CollectionValidation {

    private Collectible collectible;
    public CollectionValidation(Collectible c) {
        collectible = c;
    }
    public boolean isCollectibleValid(){
        return isAgeValid() && isColorValid() && isKeywordValid() && isConditionValid() && isCategoryValid();
    }

    private boolean isCategoryValid() {
        return isCategoryValid(collectible.getCategory().getCategory());
    }

    private boolean isConditionValid() {
        return isConditionValid(collectible.getCondition().getCondition());
    }

    private boolean isKeywordValid() {
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

    static public boolean isKeywordValid(String keyword){
        return !(keyword == null || keyword.equals("") || keyword.length() > 255);
    }

    static public boolean isConditionValid(String condition){
        return !(condition == null || condition.equals("") || condition.length() > 255);
    }
}
