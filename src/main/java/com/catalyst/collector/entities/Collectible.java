package com.catalyst.collector.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Collectible {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = {@JoinColumn(name = "collectibleId")},
            inverseJoinColumns = {@JoinColumn(name = "colorID")})
    private Set<Color> colors;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = {@JoinColumn(name = "collectibleId")},
            inverseJoinColumns = {@JoinColumn(name = "keywordID")})
    private Set<Keyword> keywords;

    @Column(nullable = false)
    private boolean sold;
    
    @Column(nullable = false)
    @JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
    private Date purchaseDate;
    
    @Column(nullable = true)
    @JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
    private Date sellDate;


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

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> color) {
        this.colors = color;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }
    
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
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
                ", color=" + colors +
                ", keywords=" + keywords +
                ", sold=" + sold +
                '}';
    }

}
