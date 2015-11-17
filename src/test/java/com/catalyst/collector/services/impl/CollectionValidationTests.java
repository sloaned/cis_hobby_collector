package com.catalyst.collector.services.impl;

import com.catalyst.collector.entities.*;
import com.catalyst.collector.services.CollectionValidation;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by gstringfellow on 11/6/2015.
 */
public class CollectionValidationTests {
    static final private String VALID_KEYWORD = "validKeyword";
    static final private String VALID_AGE = "validAge";
    static final private String VALID_COLOR = "validColor";
    static final private String VALID_CONDITION = "validCondition";
    static final private String VALID_CATEGORY = "validCategory";
    static final private String VALID_NAME = "validname";
    static final private String VALID_DESCRIPTION = "valid_description";
    static final private String VALID_CATALOG_NUMBER = "AAA-989898989898";
    static final private String INVALID_STRING_WITH_NUMBER = "Str1ng";
    static final private String INVALID_STRING_OF_SPACE = "     ";
    static final private String INVALID_NULL_STRING = (String) null;
    static final private String INVALID_1004_STRING ="this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five charactersthis is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.";
    private static final String INVALID_STRING_WITH_SPECIAL = "Str!ng";    
   
    static final private String VALID_DATE = "04/11/2001";
    static final private String PURCHASE_DATE = "10/01/2000";
    static final private String INVALID_SELL_DATE = "09/30/2000";
  
    static private CollectionValidation cv;

    @Before
    public void setup(){
        cv = new CollectionValidation();
    }

    @Test
    public void HappyIsDateValid(){
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date sample = new Date();
    	try {
			sample = sdf.parse(VALID_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	assertTrue(cv.isDateValid(sample));
    }
    
    @Test
    public void HappyIsAgeValid(){
        assertTrue(cv.isAgeValid(new Age(VALID_AGE)));
    }

    @Test
    public void HappyIsAgeIDValid(){
        assertTrue(cv.isAgeValid(new Age(1)));
    }

    @Test
    public void SadIsAgeValidLong(){
        assertFalse(cv.isAgeValid(new Age(INVALID_1004_STRING)));
    }
    @Test
    public void SadIsAgeValidNULL(){
        assertFalse(cv.isAgeValid(new Age(INVALID_NULL_STRING)));
    }
    @Test
    public void SadIsAgeValidNumber(){
        assertFalse(cv.isAgeValid(new Age(INVALID_STRING_WITH_NUMBER)));
    }
    @Test
    public void SadIsAgeValidEmpty(){
        assertFalse(cv.isAgeValid(new Age(INVALID_STRING_OF_SPACE)));
    }

    @Test
    public void HappyCategoryAgeValid(){
        assertTrue(cv.isCategoryValid(new Category(VALID_CATEGORY)));
    }

    @Test
    public void HappyCategoryAgeIDValid(){
        assertTrue(cv.isCategoryValid(new Category(1)));
    }
    @Test
    public void SadIsCategoryValidLong(){
        assertFalse(cv.isCategoryValid(new Category(INVALID_1004_STRING)));
    }
    @Test
    public void SadIsCategoryValidNULL(){
        assertFalse(cv.isCategoryValid(new Category(INVALID_NULL_STRING)));
    }
    @Test
    public void SadIsCategoryValidNumber(){
        assertFalse(cv.isCategoryValid(new Category(INVALID_STRING_WITH_SPECIAL)));
    }
    @Test
    public void SadIsCategoryValidEmpty(){
        assertFalse(cv.isCategoryValid(new Category(INVALID_STRING_OF_SPACE)));
    }

    @Test
    public void HappyColorAgeValid(){
        assertTrue(cv.isColorValid(new Color(VALID_AGE)));
    }
    @Test
    public void HappyColorAgeIDValid(){
        assertTrue(cv.isColorValid(new Color(1)));
    }
    @Test
    public void SadIsColorValidLong(){
        assertFalse(cv.isColorValid(new Color(INVALID_1004_STRING)));
    }
    @Test
    public void SadIsColorValidNULL(){
        assertFalse(cv.isColorValid(new Color(INVALID_NULL_STRING)));
    }
    @Test
    public void SadIsColorValidNumber(){
        assertFalse(cv.isColorValid(new Color(INVALID_STRING_WITH_SPECIAL)));
    }
    @Test
    public void SadIsColorValidEmpty(){
        assertFalse(cv.isColorValid(new Color(INVALID_STRING_OF_SPACE)));
    }

    @Test
    public void HappyConditionIDValid(){
        assertTrue(cv.isConditionValid(new Condition(1)));
    }
    @Test
    public void HappyConditionAgeValid(){
        assertTrue(cv.isConditionValid(new Condition(VALID_AGE)));
    }

    @Test
    public void SadIsConditionValidLong(){
        assertFalse(cv.isConditionValid(new Condition(INVALID_1004_STRING)));
    }
    @Test
    public void SadIsConditionValidNULL(){
        assertFalse(cv.isConditionValid(new Condition(INVALID_NULL_STRING)));
    }
    @Test
    public void SadIsConditionValidNumber(){
        assertFalse(cv.isConditionValid(new Condition(INVALID_STRING_WITH_SPECIAL)));
    }
    @Test
    public void SadIsConditionValidEmpty(){
        assertFalse(cv.isConditionValid(new Condition(INVALID_STRING_OF_SPACE)));
    }

    @Test
    public void HappyKeywordAgeValid(){
        assertTrue(cv.isKeywordValid(new Keyword(VALID_AGE)));
    }
    @Test
    public void SadIsKeywordValidLong(){
        assertFalse(cv.isKeywordValid(new Keyword(INVALID_1004_STRING)));
    }
    @Test
    public void SadIsKeywordValidNULL(){
        assertFalse(cv.isKeywordValid(new Keyword(INVALID_NULL_STRING)));
    }

    @Test
    public void SadIsKeywordValidEmpty(){
        assertFalse(cv.isKeywordValid(new Keyword(INVALID_STRING_OF_SPACE)));
    }

    @Test
    public void HappyIsKeywordSetValid(){
        HashSet<Keyword> ks =  new HashSet<>();
        Keyword valid1 = new Keyword();
        Keyword valid2 = new Keyword();
        Keyword valid3 = new Keyword();
        valid1.setKeyword(VALID_KEYWORD);
        valid2.setKeyword(VALID_KEYWORD);
        valid3.setKeyword(VALID_KEYWORD);

        ks.add(valid1);
        ks.add(valid2);
        ks.add(valid3);
        System.out.print(ks.size());
        assertTrue(cv.isKeywordsValid(ks));
    }
    @Test
    public void SadIsKeywordSetValidNotEnough(){
        Set<Keyword> ks =  new HashSet<>();
        Keyword valid = new Keyword();
        valid.setKeyword(VALID_KEYWORD);
        ks.add(valid);
        ks.add(valid);

        assertFalse(cv.isKeywordsValid(ks));
    }
    @Test
    public void SadIsKeywordSetValidInvalidKeyword(){
        Set<Keyword> ks =  new HashSet<>();
        Keyword valid = new Keyword();
        Keyword valid2 = new Keyword();
        Keyword invalid = new Keyword();
        invalid.setKeyword(INVALID_STRING_WITH_NUMBER);
        valid.setKeyword(VALID_KEYWORD);
        ks.add(valid);
        ks.add(valid2);
        ks.add(invalid);

        assertFalse(cv.isKeywordsValid(ks));
    }

    @Test
    public void HappyIsCollectibleValid(){
        Collectible c = new Collectible();
        Age a = new Age();
        Color l = new Color();
        Condition d = new Condition();
        Category g = new Category();
        HashSet<Keyword> ks =  new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date sample = new Date();
    	try {
			sample = sdf.parse(VALID_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
        a.setAge(VALID_AGE);
        l.setColor(VALID_COLOR);
        d.setCondition(VALID_CONDITION);
        g.setCategory(VALID_CATEGORY);
        Keyword valid1 = new Keyword();
        Keyword valid2 = new Keyword();
        Keyword valid3 = new Keyword();
        valid1.setKeyword(VALID_KEYWORD);
        valid2.setKeyword(VALID_KEYWORD);
        valid3.setKeyword(VALID_KEYWORD);
        ks.add(valid1);
        ks.add(valid2);
        ks.add(valid3);

        c.setAge(a);
        c.setKeywords(ks);
        c.setCategory(g);
        c.setColor(l);
        c.setCondition(d);
        c.setName(VALID_NAME);
        c.setDescription(VALID_DESCRIPTION);
        c.setCatalogueNumber(VALID_CATALOG_NUMBER);
    	c.setPurchaseDate(sample);
    	c.setSold(false);
        cv.setCollectible(c);

        assertTrue(cv.isCollectibleValid());
    }

    @Test
    public void HappyIsCollectibleIDValid(){
        Collectible c = new Collectible();
        Age a = new Age();
        Color l = new Color();
        Condition d = new Condition();
        Category g = new Category();
        HashSet<Keyword> ks =  new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date sample = new Date();
    	try {
			sample = sdf.parse(VALID_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
        a.setId(1);
        l.setId(1);
        d.setId(1);
        g.setId(1);
        Keyword valid1 = new Keyword();
        Keyword valid2 = new Keyword();
        Keyword valid3 = new Keyword();
        valid1.setId(1);
        valid2.setId(1);
        valid3.setId(1);
        ks.add(valid1);
        ks.add(valid2);
        ks.add(valid3);

        c.setAge(a);
        c.setKeywords(ks);
        c.setCategory(g);
        c.setColor(l);
        c.setCondition(d);
    	c.setPurchaseDate(sample);
    	c.setName(VALID_NAME);
        c.setDescription(VALID_DESCRIPTION);
        c.setCatalogueNumber(VALID_CATALOG_NUMBER);
        c.setSold(false);
        c.setId(1);
    	cv.setCollectible(c);

        assertTrue(cv.isCollectibleValid());
    }
    
    @Test
    public void SadIsCollectibleValidSellDateLaterThanPurchaseDate(){
        Collectible c = new Collectible();
        Age a = new Age();
        Color l = new Color();
        Condition d = new Condition();
        Category g = new Category();
        HashSet<Keyword> ks =  new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Date sample = new Date();
    	try {
			sample = sdf.parse(PURCHASE_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	Date sample2 = new Date();
    	try {
			sample2 = sdf.parse(INVALID_SELL_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
        a.setId(1);
        l.setId(1);
        d.setId(1);
        g.setId(1);
        Keyword valid1 = new Keyword();
        Keyword valid2 = new Keyword();
        Keyword valid3 = new Keyword();
        valid1.setId(1);
        valid2.setId(1);
        valid3.setId(1);
        ks.add(valid1);
        ks.add(valid2);
        ks.add(valid3);

        c.setAge(a);
        c.setKeywords(ks);
        c.setCategory(g);
        c.setColor(l);
        c.setCondition(d);
    	c.setPurchaseDate(sample);
    	c.setName(VALID_NAME);
        c.setDescription(VALID_DESCRIPTION);
        c.setCatalogueNumber(VALID_CATALOG_NUMBER);
        c.setSold(true);
        c.setSellDate(sample2);
    	cv.setCollectible(c);

        assertFalse(cv.isCollectibleValid());
    }
}
