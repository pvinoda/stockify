package com.example.StockCharting.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQuery(name = "Company.findByname", query = "SELECT c FROM Company c WHERE c.name = :name")
@Entity
@Table(name = "Company")
public class Company {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(nullable=false)
private String name;

@Column(nullable=false)
private String turnover;

@Column(nullable=false)
private String ceo;

@Column(nullable = false)
@Type(type = "text")
private String boardOfDirectors;

@Column(nullable = false)
@Type(type = "text")
private String companyBrief;

@OneToMany(fetch = FetchType.LAZY,mappedBy="company")
private List<StockPrice> stockPrice;

@OneToOne(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
@JsonIgnore
private IPODetail ipo;

@OneToMany(mappedBy = "company")
private List<Companystockexchangemap> compstockmap=new ArrayList();

@ManyToOne(fetch = FetchType.LAZY)
@JsonIgnore
private Sector sector;

private String sectorname;

protected Company() {
	super();
}

public Company(Long id, String name,  String turnover, String ceo, String boardOfDirectors,
		String companyBrief,String sectorname) {
	super();
	this.id = id;
	this.name = name;
	this.turnover = turnover;
	this.ceo = ceo;
	this.boardOfDirectors = boardOfDirectors;
	this.companyBrief = companyBrief;
	this.sectorname=sectorname;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getTurnover() {
	return turnover;
}

public void setTurnover(String turnover) {
	this.turnover = turnover;
}

public String getCeo() {
	return ceo;
}

public void setCeo(String ceo) {
	this.ceo = ceo;
}

public String getBoardOfDirectors() {
	return boardOfDirectors;
}

public void setBoardOfDirectors(String boardOfDirectors) {
	this.boardOfDirectors = boardOfDirectors;
}

public String getCompanyBrief() {
	return companyBrief;
}

public void setCompanyBrief(String companyBrief) {
	this.companyBrief = companyBrief;
}

public IPODetail getIpo() {
	return ipo;
}

public List<StockPrice> getStockPrice() {
	return stockPrice;
}

public void setStockPrice(List<StockPrice> stockPrice) {
	this.stockPrice = stockPrice;
}

public List<Companystockexchangemap> getCompstockmap() {
	return compstockmap;
}

public void setCompstockmap(List<Companystockexchangemap> compstockmap) {
	this.compstockmap = compstockmap;
}

public Sector getSector() {
	return sector;
}

public void setSector(Sector sector) {
	this.sector = sector;
}

public String getSectorname() {
	return sectorname;
}

public void setSectorname(String sectorname) {
	this.sectorname = sectorname;
}

public void setIpo(IPODetail ipo) {
	this.ipo = ipo;
}

}
