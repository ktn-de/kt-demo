package com.kt.demo.currency.openexchange;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.kt.demo.currency.Currency;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRatesRequestTest {

    @Mock private OpenExchangeConnector mockConnector;

	@Test
	public void verifyLatestPath() {
		ExchangeRatesRequest request = new ExchangeRatesRequest(Currency.USD);
		assertThat(request.getPath()).isEqualTo("/api/latest.json");
	}

	@Test
	public void verifyHistoricalPath() {
		ExchangeRatesRequest request = new ExchangeRatesRequest(Currency.USD, LocalDate.of(2016, 2, 3));
		assertThat(request.getPath()).isEqualTo("/api/historical/2016-02-03.json");
	}

	@Test
	public void verifyBase() {
		assertThat(new ExchangeRatesRequest(Currency.EUR).getParams().keySet()).contains("base");
	}

}
