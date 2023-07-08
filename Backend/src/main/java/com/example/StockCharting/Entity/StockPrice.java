package com.example.StockCharting.Entity;

import java.sql.Time;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "StockPrice")
@NamedQuery(name = "StockPrice.findByCodeAndName",
query = "SELECT s FROM StockPrice s"
		+ " WHERE s.companycode = :companycode AND s.exchangename=:exchangename")
public class StockPrice {
	
	@Id
	@GeneratedValue
	private long id;
	private String exchangename;
	private String companycode;
	//private LocalDateTime localdatetime;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Company company;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date datee;
	private String timee;
	private float shareprice;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getExchangename() {
		return exchangename;
	}


	public void setExchangename(String exchangename) {
		this.exchangename = exchangename;
	}


	public String getCompanycode() {
		return companycode;
	}
	
	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}



	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Date getDatee() {
		return datee;
	}


	public void setDatee(Date datee) {
		this.datee = datee;
	}


	public String getTimee() {
		return timee;
	}


	public void setTimee(String timee) {
		this.timee = timee;
	}


	public float getShareprice() {
		return shareprice;
	}


	public void setShareprice(float shareprice) {
		this.shareprice = shareprice;
	}


	public StockPrice( String exchangename, String companycode,  
			Date datee, String timee, float shareprice) {
		super();
	
		this.exchangename = exchangename;
		this.companycode = companycode;
		//this.localdatetime = localdatetime;
		this.company = company;
		this.datee = datee;
		this.timee= timee;
		this.shareprice = shareprice;
	}


	public StockPrice() {
		super();
	}


	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", exchangename=" + exchangename + ", companycode=" + companycode + ", company="
				+ company + ", datee=" + datee + ", timee=" + timee + ", shareprice=" + shareprice + "]";
	}
	

}