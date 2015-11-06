package com.catalyst.collector.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by gstringfellow on 11/4/2015.
 */
@Entity
public class Collectible {

    @GeneratedValue
    @Id
    private Integer id;

    @Column(nullable = false)
    private String catalogueNumber;

    @Column(nullable = false, length = 255,unique = true)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Age age;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Category category;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Condition condition;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "color")
    private Color color;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = {@JoinColumn(name = "collectibleId")},
            inverseJoinColumns = {@JoinColumn(name = "keywordID")})
    private Set<Keyword> keywords;

    @Column
    private boolean sold;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getCatalogueNumber() {
        return catalogueNumber;
    }

    public void setCatalogueNumber(String catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Collectible{" +
                "catalogueNumber='" + catalogueNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", condition=" + condition +
                ", color=" + color +
                ", keywords=" + keywords +
                ", sold=" + sold +
                '}';
    }
}
