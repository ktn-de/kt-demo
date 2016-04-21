package com.kt.demo.currency.openexchange;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;

import com.kt.demo.currency.Currency;
import com.kt.demo.currency.ExchangeRates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OpenExchangeProviderTestIT {

//	@Autowired // TODO: there is an issue with @EnablingCaching
	OpenExchangeProvider provider;
	
	@Before
	public void setUp() {
		provider = new OpenExchangeProvider();
		provider.connector = new OpenExchangeConnector();
	}

	@Test
	public void requestLatest() throws Exception {
		ExchangeRates exchangeRates = provider.getExchangeRates(Currency.USD, LocalDate.now());
		assertThat(exchangeRates).isNotNull();
		assertThat(exchangeRates.getRates()).isNotEmpty();
	}

	@Test
	public void requestHistorical() throws Exception {
		ExchangeRates exchangeRates = provider.getExchangeRates(Currency.USD, LocalDate.of(2016, 4, 1));
		assertThat(exchangeRates).isNotNull();
		assertThat(exchangeRates.getRates()).isNotEmpty();
	}

	@Test
	public void requestFailure() throws Exception {
		assertThatThrownBy(() -> provider.getExchangeRates(Currency.EUR, LocalDate.of(2016, 4, 1))) 
        .isInstanceOf(HttpClientErrorException.class)
        .hasMessage("403 Forbidden")
        .hasNoCause();
	}
}
