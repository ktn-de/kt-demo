package com.kt.demo.currency.openexchange;

import java.time.LocalDate;
import java.util.Map;

import com.kt.demo.currency.Currency;

public class ExchangeRatesRequest extends BaseRequest {

	Currency base;
	LocalDate date;
	
	public ExchangeRatesRequest(Currency base) {
		init(base, LocalDate.now());
	}

	public ExchangeRatesRequest(Currency base, LocalDate date) {
		init(base, date);
	}

	private void init(Currency base, LocalDate date) {
		this.date = date;
		if (date.isBefore(LocalDate.now())) {
			setPath("/api/historical/" + date + ".json");
		} else {
			setPath("/api/latest.json");
		}
		this.base = base;
		params.add("base", base.name());
	}

	public static class Response {
		String disclaimer;
		String license;
		long timestamp;
		Currency base;
		Map<Currency, Double> rates;

		public String getDisclaimer() {
			return disclaimer;
		}

		public void setDisclaimer(String disclaimer) {
			this.disclaimer = disclaimer;
		}

		public String getLicense() {
			return license;
		}

		public void setLicense(String license) {
			this.license = license;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public Currency getBase() {
			return base;
		}

		public void setBase(Currency base) {
			this.base = base;
		}

		public Map<Currency, Double> getRates() {
			return rates;
		}

		public void setRates(Map<Currency, Double> rates) {
			this.rates = rates;
		}

		@Override
		public String toString() {
			return "Response [disclaimer=" + disclaimer + ", license=" + license + ", timestamp=" + timestamp
					+ ", base=" + base + ", rates=" + rates + "]";
		}

	}
}
