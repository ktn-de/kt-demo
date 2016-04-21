package com.kt.demo.currency;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceTest {

	@Mock
	Provider mockProvider;

	@InjectMocks
	CurrencyService service;

	@Test
	public void verifyNothingReceived() {
		CurrencyRequest request = new CurrencyRequest();
		service.updateRate(request);
		assertThat(request.getErrorMsg()).isEqualTo("nothing received");
	}

	@Test
	public void verifyErrorMsg1() {
		when(mockProvider.getExchangeRates(any(), any())).thenThrow(new RuntimeException("not available"));
		CurrencyRequest request = new CurrencyRequest();
		service.updateRate(request);
		assertThat(request.getErrorMsg()).isEqualTo("not available");
	}

}
