package com.catalyst.collector.entities;

import javax.persistence.*;

@Entity
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
    @Column(nullable = false, unique = true)
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
