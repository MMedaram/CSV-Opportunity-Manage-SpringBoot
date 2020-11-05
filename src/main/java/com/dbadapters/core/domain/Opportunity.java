package com.dbadapters.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CREATE_OPPORTUNITY")
public class Opportunity implements Serializable{

	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "opportuity_name",nullable = false)
	private String opportuityName;
	
	@NotNull
	@Column(name = "account_name",nullable = false)
	private String accountName;
	
	@NotNull
	@Column(name = "exp_book_date",nullable = false)
	private String expBookDate;
	
	@NotNull
	@Column(name = "exp_product",nullable = false)
	private String expProduct;
	
	@NotNull
	@Column(name = "exp_service",nullable = false)
	private String expService;
	
	@NotNull
	@Column(name = "exist_opp_name",nullable = false)
	private String existOppName;

	@NotNull
	@Column(name = "opp_url",nullable = false)
	private String oppUrl;


	public Opportunity() {
		
	}


	public Opportunity(@NotNull String opportuityName, @NotNull String accountName,
			@NotNull String expBookDate, @NotNull String expProduct, @NotNull String expService,
			@NotNull String existOppName, @NotNull String oppUrl) {
		super();
		this.opportuityName = opportuityName;
		this.accountName = accountName;
		this.expBookDate = expBookDate;
		this.expProduct = expProduct;
		this.expService = expService;
		this.existOppName = existOppName;
		this.oppUrl = oppUrl;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOpportuityName() {
		return opportuityName;
	}


	public void setOpportuityName(String opportuityName) {
		this.opportuityName = opportuityName;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getExpBookDate() {
		return expBookDate;
	}


	public void setExpBookDate(String expBookDate) {
		this.expBookDate = expBookDate;
	}


	public String getExpProduct() {
		return expProduct;
	}


	public void setExpProduct(String expProduct) {
		this.expProduct = expProduct;
	}


	public String getExpService() {
		return expService;
	}


	public void setExpService(String expService) {
		this.expService = expService;
	}


	public String getExistOppName() {
		return existOppName;
	}


	public void setExistOppName(String existOppName) {
		this.existOppName = existOppName;
	}


	public String getOppUrl() {
		return oppUrl;
	}


	public void setOppUrl(String oppUrl) {
		this.oppUrl = oppUrl;
	}


	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", opportuityName=" + opportuityName + ", accountName=" + accountName
				+ ", expBookDate=" + expBookDate + ", expProduct=" + expProduct + ", expService=" + expService
				+ ", existOppName=" + existOppName + ", oppUrl=" + oppUrl + "]";
	}

	
}
