package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String login;
	private String password;
	public void setId(Integer id) {this.id=id;}
	public void setLogin(String login) {this.login=login;}
	public void setPassword(String password) {this.password=password;}
	public Integer getId () {return this.id;}
	public String getLogin () {return this.login;}
	public String getPassword () {return this.password;}

}
