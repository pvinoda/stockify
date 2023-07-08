package com.example.StockCharting.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class CompanyCompareRequest {
	
private String companyname;
private String exchangename;
@JsonFormat(pattern="dd-MM-yyyy")
private Date fromperiod;
@JsonFormat(pattern="dd-MM-yyyy")
private Date toperiod;
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getExchangename() {
	return exchangename;
}
public void setExchangename(String exchangename) {
	this.exchangename = exchangename;
}

public Date getFromPeriod() {
	return fromperiod;
}
public void setFromPeriod(Date fromPeriod) {
	this.fromperiod = fromPeriod;
}
public Date getToPeriod() {
	return toperiod;
}
public void setToPeriod(Date toPeriod) {
	this.toperiod = toPeriod;
}

public CompanyCompareRequest(String companyname, String exchangename, Date fromPeriod, Date toPeriod) {
	super();
	this.companyname = companyname;
	this.exchangename = exchangename;
	this.fromperiod = fromPeriod;
	this.toperiod = toPeriod;
}
public CompanyCompareRequest() {
	super();
}
@Override
public String toString() {
	return "CompanyCompareRequest [companyname=" + companyname + ", exchangename=" + exchangename + ", fromperiod="
			+ fromperiod + ", toperiod=" + toperiod + "]";
}


}
