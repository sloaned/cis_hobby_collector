package com.catalyst.collector.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Column(nullable = false, unique = true, length=255)
	private String color;
	public Color(){}

	public Color(int i) {
		id=i;
	}

	@Override
	public String toString() {
		return "Color{" +
				"id=" + id +
				", color='" + color + '\'' +
				'}';
	}

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
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
