package com.example.StockCharting.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@NamedQuery(name = "Sector.findByname", query = "SELECT s FROM Sector s WHERE s.name = :name")
@Entity
public class Sector {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
@Column 
private String name;
@Column
private String description;
@OneToMany(mappedBy = "sector",cascade=CascadeType.ALL)
@JsonIgnore
private List<Company> companies =new ArrayList();
protected Sector() {
	super();
}
public Sector( String name, String description) {
	super();
	this.name = name;
	this.description = description;
}
public Long getId() {
	return id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public List<Company> getCompanies() {
	return companies;
}
public void setCompanies(List<Company> companies) {
	this.companies = companies;
}


}
