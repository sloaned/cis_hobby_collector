package com.catalyst.collector.entities;


import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Keyword {

    private static final String regex = "[^a-zA-Z+_]";
    private static final Pattern pattern = Pattern.compile(regex);
    private Matcher matcher;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 255)
    private String word;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isValid() {
        if (word == null)
            return false;
        matcher = pattern.matcher(word);
        return !word.equals("") && word.length() < 256 && !matcher.find();

    }
}
