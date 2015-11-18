package com.catalyst.collector.services;

import com.catalyst.collector.entities.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private static final String dateRegex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$"; 
    private static final Pattern datePattern = Pattern.compile(dateRegex);
    private Matcher matcher;

    public CollectionValidation() {}

    public boolean isCollectibleValid(){
        return isAgeValid() && isColorsValid() && isKeywordsValid() && isConditionValid() && isCategoryValid() && isPurchaseDateValid() &&
        		(collectible.getSellDate() == null || isSellDateValid()) &&
        		(collectible.getSellDate() == null || !collectible.getPurchaseDate().after(collectible.getSellDate())) &&
        		collectible.getName() != null && !collectible.getName().isEmpty() &&
                collectible.getDescription() != null && !collectible.getDescription().isEmpty() &&
                collectible.getCatalogueNumber() != null && !collectible.getCatalogueNumber().isEmpty() 
                && collectible.getPurchaseDate() != null && (!collectible.isSold() || collectible.getSellDate() != null);
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
        int length = 0;
        if(keywords.size() < 3)
            return false;
        for (Keyword k: keywords) {
            length+=k.getKeyword().length();
            if(!isKeywordValid(k))
                return false;
        }
        return length<=1000;
    }

    private boolean isColorsValid() {
        if(collectible.getColors().size() < 1)
            return false;
        for (Color c: collectible.getColors()) {
            if(!isColorValid(c))
                return false;
        }
        return true;
    }

    private boolean isAgeValid() {
        return isAgeValid(collectible.getAge());
    }
    
    private boolean isPurchaseDateValid(){
    	return isDateValid(collectible.getPurchaseDate());
    }
    
    private boolean isSellDateValid(){
    	return isDateValid(collectible.getSellDate());
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
            return category.getId() != null && category.getId() > 0;

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
    
    public boolean isDateValid(Date date){
    	if(date == null)
    	{
    		return false;
    	}
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    	String dateString = formatter.format(date);
    	matcher = datePattern.matcher(dateString);
    	if(!matcher.matches())
    	{
    		return false;
    	}
    	int month = Integer.parseInt(dateString.substring(0, 2));
    	int day = Integer.parseInt(dateString.substring(3, 5));
    	int year = Integer.parseInt(dateString.substring(6, 10));
    	
    	if(month < 1 || month > 12)
    	{
    		return false;
    	}
    	
    	int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    	if(year%400 == 0 || (year%100 != 0 && year%4 == 0))
    	{
    		monthLength[1] = 29;
    	}
    	
    	if(day < 0 || day > monthLength[month-1])
    	{
    		return false;
    	}
    	return true;  		
    }
}
