package com.catalyst.collector.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
    @Column(nullable = false, unique = true)
	@Size(max = 255)
	String color;
	public Color(){}
	/**
	 * @param color
	 */
	public Color(String color){
		this.color=color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
