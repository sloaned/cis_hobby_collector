package com.catalyst.collector.entities;

import javax.persistence.*;

/**
 * Created by gfisher on 11/4/2015.
 */
@Entity
public class Age {
    public Integer getAge_id() {
        return age_id;
    }

    public void setAge_id(Integer age_id) {
        this.age_id = age_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer age_id;
    @Column(nullable = false, unique = true, length=255)
    private String age;


    public Age(){}

    /**
     * This setter creates a new age category
     * @param age input from the user
     */
    public Age(String age) {
        this.age = age;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
