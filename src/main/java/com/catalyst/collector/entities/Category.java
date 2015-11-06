package com.catalyst.collector.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", category='" + category + '\'' +
				'}';
	}

	@Column(nullable = false, unique = true, length=255)
	private String category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String name) {
		this.category = name;
	}

}
