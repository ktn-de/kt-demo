package com.kt.demo.currency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

	private static final Logger log = LoggerFactory.getLogger(CurrencyService.class);

	@Autowired
	Provider provider;

	public void updateRate(CurrencyRequest request) {
		try {
			ExchangeRates rates = provider.getExchangeRates(request.getBase(), request.getDate());
			double rate = rates.getRate(request.getTarget());
			request.setRate(rate);
			log.info("update rate: " + request);
		} catch (Exception e) {
			log.error("update rate failed: " + request, e);
		}
	}

}
