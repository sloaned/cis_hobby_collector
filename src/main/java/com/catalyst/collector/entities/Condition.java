package com.catalyst.collector.entities;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;

@Entity
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length=255)
    private String condition;

    public Condition(String Cond) {
        condition = Cond;
    }

    public Condition() {

    }

    @Override
    public String toString() {
        return "Condition{" +
                "id=" + id +
                ", condition='" + condition + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
