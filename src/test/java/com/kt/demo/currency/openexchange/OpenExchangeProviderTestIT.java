package com.kt.demo.currency.openexchange;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kt.demo.config.WebAppConfigurationAware;
import com.kt.demo.currency.Currency;
import com.kt.demo.currency.ExchangeRates;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenExchangeProviderTestIT extends WebAppConfigurationAware {

	@Autowired
	OpenExchangeProvider provider;

	@Test
	public void testLatest() throws Exception {
		ExchangeRates exchangeRates = provider.getExchangeRates(Currency.USD, LocalDate.now());
		assertThat(exchangeRates).isNotNull();
		assertThat(exchangeRates.getRates()).isNotEmpty();
	}

	@Test
	public void testHistorical() throws Exception {
		ExchangeRates exchangeRates = provider.getExchangeRates(Currency.USD, LocalDate.of(2016, 4, 1));
		assertThat(exchangeRates).isNotNull();
		assertThat(exchangeRates.getRates()).isNotEmpty();
	}
}
