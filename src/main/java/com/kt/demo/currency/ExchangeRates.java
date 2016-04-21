package com.kt.demo.currency;

import java.util.Map;

public class ExchangeRates {
    
	Currency base;
	long timestamp;
    Map<Currency, Double> rates;

	public Currency getBase() {
		return base;
	}

	public void setBase(Currency base) {
		this.base = base;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Map<Currency, Double> getRates() {
		return rates;
	}

	public void setRates(Map<Currency, Double> rates) {
		this.rates = rates;
	}
	
	public double getRate(Currency target) {
		return rates.get(target);
	}

	public void filterUnwanted() {
		if (rates != null) {
			rates.remove(Currency.UNKNOWN);
		}
	}

	@Override
	public String toString() {
		return "ExchangeRates [base=" + base + ", timestamp=" + timestamp + ", rates="
				+ rates + "]";
	}

}
