package com.catalyst.collector.services;

import com.catalyst.collector.entities.*;
import org.springframework.stereotype.Service;


/**
 * Created by gstringfellow on 11/6/2015.
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
    public CollectionValidation() {}

    public boolean isCollectibleValid(){
        return isAgeValid() && isColorValid() && isKeywordValid() && isConditionValid() && isCategoryValid();
    }

    private boolean isCategoryValid() {
        return isCategoryValid(collectible.getCategory());
    }

    private boolean isConditionValid() {
        return isConditionValid(collectible.getCondition());
    }

    private boolean isKeywordValid() {
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
        return (age != null && age.getAge() != null && age.getAge().length() <= 255 && age.getAge().matches("^[a-zA-Z]*$") && !age.getAge().matches(".*\\d.*") && !age.getAge().trim().equals(""));
         //Maximum of 255 characters for an age, no digits allowed

        }

    public boolean isCategoryValid(Category category){
        return !(category == null || category.getCategory() == null || category.getCategory().length() > 255 || (category.getCategory().trim()).equals("")
        			|| !category.getCategory().matches("^[a-zA-Z0-9]*$") || category.getCategory().matches("\\s"));
    }


    public boolean isColorValid(Color color){
        return !(color == null || color.getColor() == null || color.getColor().trim().equals("") || color.getColor().length() > 255
                    || !color.getColor().matches("^[a-zA-Z0-9]*$") || color.getColor().matches("\\s"));
    }

    public boolean isKeywordValid(Keyword keyword){
        return !(keyword == null || keyword.getKeyword() == null || keyword.getKeyword().equals("") || keyword.getKeyword().length() > 255
                    || !keyword.getKeyword().matches("^[a-zA-Z0-9]*$") || keyword.getKeyword().matches("\\s"));
    }

    public boolean isConditionValid(Condition condition){
        return !(condition == null || condition.getCondition() != null || condition.getCondition().equals("") || condition.getCondition().length() > 255
                    && condition.getId() == null);
    }
}
