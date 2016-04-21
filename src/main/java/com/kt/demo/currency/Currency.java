package com.kt.demo.currency;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Currency {
	USD, EUR, GBP, CHF, AUD, JPY, HUF, UNKNOWN;
	
	@JsonCreator
	public static Currency fromString(String value) {
		for (Currency currency : values()) {
			if (currency.name().equalsIgnoreCase(value)) {
				return currency;
			}
		}
		return UNKNOWN;
	}
}
