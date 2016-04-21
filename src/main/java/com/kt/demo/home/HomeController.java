package com.kt.demo.home;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Queue;

import javax.validation.Valid;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kt.demo.currency.Currency;
import com.kt.demo.currency.CurrencyRequest;
import com.kt.demo.currency.CurrencyService;

@Controller
public class HomeController {
	
    @Autowired
	CurrencyService currencyService;
    
    Queue<CurrencyRequest> lastRequests = new CircularFifoQueue<CurrencyRequest>(10);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Principal principal, ModelMap model) throws Exception {
		if (principal == null) {
			return "home/homeNotSignedIn";
		}
		model.addAttribute("name", principal);
		addLists(model);
		model.addAttribute("currencyRequest", new CurrencyRequest(Currency.USD, Currency.EUR, LocalDate.now()));
        return "home/homeSignedIn";
	}

	private void addLists(ModelMap model) {
		model.addAttribute("lastRequests", lastRequests);
		model.addAttribute("currencyList", Currency.ListAll);
	}

	@RequestMapping(value = "/queryRates", method = RequestMethod.POST)
    public String queryRates(ModelMap model, @ModelAttribute("currencyRequest") @Valid CurrencyRequest request) throws Exception {
		currencyService.updateRate(request);
		lastRequests.add(request);
        addLists(model);
        return "home/homeSignedIn";
    }
}
