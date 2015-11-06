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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
    @GenericGenerator(name = "id_gen",
            strategy = "com.catalyst.collector.services.CatalogNumberGenerator")
    private String catalogueNumber;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ageId")
    private Age age;

    @Column(nullable = true, length = 1000)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conditionId")
    private Condition condition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colorId")
    private Color color;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "collectibleId")},
            inverseJoinColumns = {@JoinColumn(name = "keywordID")})
    private Set<Keyword> keywords;

    private boolean sold;

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
