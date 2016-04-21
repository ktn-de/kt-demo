package com.kt.demo.currency;

import java.time.LocalDate;

public interface Provider {
	public ExchangeRates getExchangeRates(Currency base, LocalDate date);
}