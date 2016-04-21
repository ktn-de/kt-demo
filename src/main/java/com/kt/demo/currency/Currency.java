package com.kt.demo.currency;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Currency {
	USD, EUR, GBP, CHF, AUD, JPY, HUF, UNKNOWN;

	public static List<Currency> ListAll = Arrays.stream(values())
			.filter(p -> p != UNKNOWN)
			.collect(Collectors.toList());

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
