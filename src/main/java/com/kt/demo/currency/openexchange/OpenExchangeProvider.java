package com.kt.demo.currency.openexchange;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.kt.demo.config.CacheConfig;
import com.kt.demo.currency.Currency;
import com.kt.demo.currency.ExchangeRates;
import com.kt.demo.currency.Provider;
import com.kt.demo.currency.openexchange.ExchangeRatesRequest.Response;

@Component
public class OpenExchangeProvider implements Provider {

	private static final Logger log = LoggerFactory.getLogger(OpenExchangeProvider.class);

	@Autowired
	OpenExchangeConnector connector;

	@Override
	@Cacheable(CacheConfig.CACHE_EXCHANGE_RATES)
	public ExchangeRates getExchangeRates(Currency base, LocalDate date) {
		ExchangeRates exchangeRates = new ExchangeRates();
		exchangeRates.setBase(base);
		ExchangeRatesRequest request = new ExchangeRatesRequest(base, date);
		Response response = connector.getResponse(request.getPath(), request.getParams(), Response.class);
		if (response != null) {
			exchangeRates.setTimestamp(response.getTimestamp());
			exchangeRates.setRates(response.getRates());
			exchangeRates.filterUnwanted();
		}
		log.info("exchangeRates: " + exchangeRates);
		return exchangeRates;
	}

}