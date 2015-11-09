package com.catalyst.collector.services;

import com.catalyst.collector.entities.*;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@Service
public class CollectionValidation {

    public Collectible getCollectible() {
        return collectible;
    }

    public void setCollectible(Collectible collectible) {
        this.collectible = collectible;
    }

    private Collectible collectible;
    private static final String keywordRegex = "[^a-zA-Z\\d]";
    private static final Pattern keywordPattern = Pattern.compile(keywordRegex);
    private Matcher matcher;

    public CollectionValidation() {}

    public boolean isCollectibleValid(){
        return isAgeValid() && isColorValid() && isKeywordsValid() && isConditionValid() && isCategoryValid();
    }

    private boolean isCategoryValid() {
        return isCategoryValid(collectible.getCategory());
    }

    private boolean isConditionValid() {
        return isConditionValid(collectible.getCondition());
    }

    private boolean isKeywordsValid() {
        for (Keyword k: collectible.getKeywords()) {
            if(!isKeywordValid(k))
                return false;
        }
        return true;
    }

    private boolean isColorValid() {
        return isColorValid(collectible.getColor());
    }

    private boolean isAgeValid() {
        return isAgeValid(collectible.getAge());
    }

    static public boolean isAgeValid(Age age){
        return (age != null && age.getAge() != null && age.getAge().length() <= 255 && !age.getAge().matches(".*\\d.*") && !age.getAge().trim().equals("")
                    || age.getId() != null);
         //Maximum of 255 characters for an age, no digits allowed

        }

    public boolean isCategoryValid(Category category){
        return !(category == null || category.getCategory() == null ||category.getCategory().length() > 255 ||(category.getCategory().trim()).equals("")|| category.getCategory().matches(".*\\d.*")
                    && category.getId() == null);
    }


    public boolean isColorValid(Color color){
        return !(color == null || color.getColor() == null|| color.getColor().trim().equals("") || color.getColor().length() > 255
                    && color.getId() == null);
    }

    public boolean isKeywordValid(String keyword){
        if (keyword == null)
            return false;

        matcher = keywordPattern.matcher(keywordRegex);
        return !keyword.equals("") && keyword.length() < 256 && !matcher.find();
    }

    public boolean isConditionValid(Condition condition){
        return !(condition == null || condition.getCondition() != null || condition.getCondition().equals("") || condition.getCondition().length() > 255
                    && condition.getId() == null);
    }
}
