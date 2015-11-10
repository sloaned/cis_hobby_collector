package com.catalyst.collector.services;

import com.catalyst.collector.entities.*;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Validation class for all entities
 */
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
        if(collectible.getKeywords().size() < 3)
            return false;
        for (Keyword k: collectible.getKeywords()) {
            if(!isKeywordValid(k))
                return false;
        }
        return true;
    }
    public boolean isKeywordsValid(Set<Keyword> keywords) {
        if(keywords.size() < 3)
            return false;
        for (Keyword k: keywords) {
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


    public boolean isAgeValid(Age age){
        if(age == null){return false;}
        if(age.getAge() == null){return age.getId()!= null;}
        return (age.getAge().length() <= 255 && !age.getAge().matches(".*[\\d\\W_].*") && !age.getAge().trim().equals(""));
         //Maximum of 255 characters for an age, no digits allowed

        }

    public boolean isCategoryValid(Category category){
        if(category == null)
            return false;
        String name = category.getCategory();
        if (name == null)
            return category.getId() != null;

        return !(name.length() > 255 || (name.trim()).equals("")
        			|| !name.matches("^[a-zA-Z0-9]*$") || name.matches("\\s"));
    }


    public boolean isColorValid(Color color){
        if(color == null)
            return false;
        String name = color.getColor();
        if (name == null)
            return color.getId() != null;

        return !(name.trim().equals("") || name.length() > 255
                    || !name.matches("^[a-zA-Z0-9]*$") || name.matches("\\s"));
    }

    public boolean isKeywordValid(Keyword keyword){
        if (keyword == null)
            return false;
        if (keyword.getKeyword() == null)
            return keyword.getId() != null;

        matcher = keywordPattern.matcher(keyword.getKeyword());
        return !keyword.getKeyword().equals("") && keyword.getKeyword().length() < 256 && !matcher.find();
    }

    public boolean isConditionValid(Condition condition){
        if (condition == null)
            return false;
        if (condition.getCondition() == null)
            return condition.getId() != null;

        matcher = keywordPattern.matcher(condition.getCondition());
        return !condition.getCondition().equals("") && condition.getCondition().length() < 256 && !matcher.find();
    }
}
