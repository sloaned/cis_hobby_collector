package com.catalyst.collector.entities;

import javax.persistence.*;

/**
 * Created by gfisher on 11/4/2015.
 */
@Entity
public class Age {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int age_id;
    @Column(nullable = false, unique = true)
    private String age;

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
