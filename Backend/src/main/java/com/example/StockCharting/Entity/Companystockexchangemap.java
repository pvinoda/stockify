package com.example.StockCharting.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQueries({
		@NamedQuery(name = "Companystockexchangemap.findByCodeAndName", query = "SELECT c FROM Companystockexchangemap c WHERE c.companycode = :companycode AND c.stockexchangename=:stockexchangename"),
		@NamedQuery(name = "Companystockexchangemap.findByCompanyNameAndExchangeName", query = "SELECT c FROM Companystockexchangemap c WHERE c.companyname = :companyname AND c.stockexchangename=:stockexchangename")

})
@Entity
@Table(name = "CompanyStockexchangemap")
public class Companystockexchangemap {
	public Companystockexchangemap() {
		super();

	}

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "companycode")
	private String companycode;

	private String companyname;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	public Company company;
	private String stockexchangename;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private StockExchange stockexchange;

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companyCode) {
		this.companycode = companyCode;
	}

	@Override
	public String toString() {
		return "Companystockexchangemap [id=" + id + ", companycode=" + companycode + ", companyname=" + companyname
				+ ", company=" + company + ", stockexchangename=" + stockexchangename + ", stockexchange="
				+ stockexchange + "]";
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockExchange getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(StockExchange stockexchange) {
		this.stockexchange = stockexchange;
	}

	public long getId() {
		return id;
	}

	public Companystockexchangemap(long id, String companyCode, String companyname, String stockexchangename) {
		super();
		this.id = id;
		this.companycode = companyCode;
		this.companyname = companyname;
		this.stockexchangename = stockexchangename;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getStockexchangename() {
		return stockexchangename;
	}

	public void setStockexchangename(String stockexchangename) {
		this.stockexchangename = stockexchangename;
	}

	public void setId(long id) {
		this.id = id;
	}
}
