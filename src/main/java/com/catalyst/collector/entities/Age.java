package com.catalyst.collector.entities;

import javax.persistence.*;

/**
 * Created by gfisher on 11/4/2015.
 */
@Entity
public class Age {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true, length = 255)
    private String  age;


    public Age(){}

    @Override
    public String toString() {
        return "Age{" +
                "id=" + id +
                ", age='" + age + '\'' +
                '}';
    }

    /**
     * This setter creates a new age category
     * @param age input from the user
     */
    public Age(String age) {
        this.age = age;
    }
    public Age(int id) {
        this.id = new Integer(id);
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getId() {
        return id.intValue();
    }

    public void setId(Integer age_id) {
        this.id = age_id;
    }
}
