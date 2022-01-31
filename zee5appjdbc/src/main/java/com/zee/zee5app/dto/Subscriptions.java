package com.zee.zee5app.dto;

import java.math.BigDecimal;

import com.zee.zee5app.dto.UserBankDetails;
import com.zee.zee5app.exception.InvalidAmountException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
@Data
public class Subscriptions {
	private String id;
	private String dateofpurchase;
	private String expirydate;
	private int subscription_cost;
	private String paymentmode;
	private String status;
	private String type;
	
	
	private String autorenewal;
	
	private String regid;
	private String packcountry;
	@Setter(value = AccessLevel.NONE)
	private int amount;
	
	public void setAmount(int amount) throws InvalidAmountException {
		int subscription_cost = 2000;
		UserBankDetails userdetails=new UserBankDetails();
		System.out.println(this.amount);
		if(subscription_cost<userdetails.getBankbalance())
			throw new InvalidAmountException("bank balance is less than the subscription amount cost");
		if(amount<subscription_cost)
			throw new InvalidAmountException("Please enter valid amount");
		this.amount = amount;
	}
	public Subscriptions() {
		
	}

	public Subscriptions(String id, String dateofpurchase, String expirydate, int subscription_cost,
			String paymentmode, String status, String type, String autorenewal, String regid) {
		super();
		this.id = id;
		this.dateofpurchase = dateofpurchase;
		this.expirydate = expirydate;
		this.subscription_cost = subscription_cost;
		this.paymentmode = paymentmode;
		this.status = status;
		this.type = type;
		this.autorenewal = autorenewal;
		this.regid = regid;
	}
}
