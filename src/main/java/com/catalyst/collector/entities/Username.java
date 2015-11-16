package com.catalyst.collector.entities;

import javax.persistence.*;

/*
 * Created by D. Sloane 11/13/2015
 */
@Entity
public class Username {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
  
	@Column(nullable = false, unique = true, length = 255)
    private String  username;
 
	@Column(nullable = false, length = 255)
    private String password;
    
    public Username(){}
    
    @Override
	public String toString() {
		return "Username{" +
				"id=" + id +
				", username='" + username + 
				", password='" + password + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
