package com.example.cryptocurrencies.controller;

import com.example.cryptocurrencies.DTO.CurrencyExchangeResultsDTO;
import com.example.cryptocurrencies.DTO.ExchangeCurrencyDTO;
import com.example.cryptocurrencies.DTO.ExchangeRatesDTO;
import com.example.cryptocurrencies.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/{currency}")
    public ExchangeRatesDTO getCurrencyExchangeRate(@PathVariable String currency, @RequestParam List<String> filter){
        return currencyService.getCurrencyExchangeRate(currency, filter);
    }

    @PostMapping("/exchange")
    public CurrencyExchangeResultsDTO exchangeCurrency(@RequestBody ExchangeCurrencyDTO exchangeCurrencyDTO){
        return currencyService.exchangeCurrency(exchangeCurrencyDTO);
    }
}
