package com.kt.demo.currency.openexchange;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenExchangeConnectorTestIT {

	OpenExchangeConnector connector = new OpenExchangeConnector();

	@Test
	public void requestRates() throws Exception {
		String result = connector.getResponse("/", new LinkedMultiValueMap<>(), String.class);
		assertThat(result).isNotNull();
	}

}
