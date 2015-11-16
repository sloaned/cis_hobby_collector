package com.catalyst.collector.entities;

import java.util.Set;

/**
 * Created by gfisher on 11/16/2015.
 */
public class Search {
    private String category;
    private String color;
    private String condition;
    private String age;
    private String description;
    private String name;
    private String keyword;
    private boolean sold;
    private String catalogNumber;

    public Search(){}

    public Search(String category, String color, String condition, String age, String description, String name, String keyword, boolean sold, String catalogueNumber) {
        this.category = category;
        this.color = color;
        this.condition = condition;
        this.age = age;
        this.description = description;
        this.name = name;
        this.keyword = keyword;
        this.sold = sold;
        this.catalogNumber = catalogNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeywords(String keyword) {
        this.keyword = keyword;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getCatalogueNumber() {
        return catalogNumber;
    }

    public void setCatalogueNumber(String catalogueNumber) {
        this.catalogNumber = catalogueNumber;
    }
}
