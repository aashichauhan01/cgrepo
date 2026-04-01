package com.cg.entity;

public class Account {
	private Integer accountId;
	private String custName;
	private Double amt;
	
	
	public Account()
	{
		
	}
	
	
	public Account(Integer accountId, String custName, Double amt) {
		super();
		this.accountId = accountId;
		this.custName = custName;
		this.amt = amt;
	}

	
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	
	

}
