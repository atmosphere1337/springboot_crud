package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String city;
	private String country;
	private Integer population;
	public void setId(Integer id) {this.id=id;}
	public void setCity(String city) {this.city=city;}
	public void setCountry(String country) {this.country=country;}
	public void setPopulation(Integer population) {this.population=population;}
	public Integer getId() {return this.id;} 
	public String getCity() {return this.city;} 
	public String getCountry() {return this.country;} 
	public Integer getPopulation() {return this.population;} 
}
