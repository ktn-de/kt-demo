package com.kt.demo.currency;

import java.time.LocalDate;

public class CurrencyRequest {
	
	LocalDate date;
	Currency base;
	Currency target;
	double rate;
	
	public CurrencyRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public CurrencyRequest(Currency base, Currency target) {
		super();
		this.date = LocalDate.now();
		this.base = base;
		this.target = target;
	}

	public CurrencyRequest(Currency base, Currency target, LocalDate date) {
		super();
		this.date = date;
		this.base = base;
		this.target = target;
	}

	public boolean isHistorical() {
		return date.isBefore(LocalDate.now());
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Currency getBase() {
		return base;
	}

	public void setBase(Currency base) {
		this.base = base;
	}

	public Currency getTarget() {
		return target;
	}

	public void setTarget(Currency target) {
		this.target = target;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "CurrencyRequest [date=" + date + ", base=" + base + ", target=" + target + ", rate=" + rate + "]";
	}

}
