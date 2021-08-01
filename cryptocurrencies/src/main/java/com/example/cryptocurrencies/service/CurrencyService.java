package com.example.cryptocurrencies.service;

import com.example.cryptocurrencies.DTO.CurrencyExchangeResultsDTO;
import com.example.cryptocurrencies.DTO.CurrencyToExchangeDTO;
import com.example.cryptocurrencies.DTO.ExchangeCurrencyDTO;
import com.example.cryptocurrencies.DTO.ExchangeRatesDTO;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;
    private final static String urlBeginning = "https://api.nomics.com/v1/currencies/ticker?key=c94c35f1724e385479c34d524a0420bd2071bdb1";
    private final static String urlEnd = "&interval=1d&per-page=100&page=1";

    public CurrencyExchangeResultsDTO exchangeCurrency(ExchangeCurrencyDTO exchangeCurrencyDTO){
        Map<String, Double> results = getExchangeValue(exchangeCurrencyDTO.getFrom(), exchangeCurrencyDTO.getTo());
        List<CurrencyToExchangeDTO> currencyToExchangeDTOList = new ArrayList<>();
        results.forEach((key, value) -> {
            createOneCurrencyInformationToExchange(key, value, exchangeCurrencyDTO, currencyToExchangeDTOList);
        });
        return new CurrencyExchangeResultsDTO(exchangeCurrencyDTO.getFrom(), currencyToExchangeDTOList);
    }
    private void createOneCurrencyInformationToExchange(String key, Double value, ExchangeCurrencyDTO exchangeCurrencyDTO, List<CurrencyToExchangeDTO> currencyToExchangeDTOList){
        Integer amount = exchangeCurrencyDTO.getAmount();
        Double fee = amount * value * 0.01;
        Double result = value * amount - fee;
        CurrencyToExchangeDTO currencyToExchangeDTO = new CurrencyToExchangeDTO(key, value, amount, result, fee);
        currencyToExchangeDTOList.add(currencyToExchangeDTO);
    }

    public ExchangeRatesDTO getCurrencyExchangeRate(String currency, List<String> filter){
        return new ExchangeRatesDTO(currency, getExchangeValue(currency, filter));
    }

    private Map<String, Double> getExchangeValue(String currency, List<String> filter){
        Map<String, Double> results = new HashMap<>();
        for(String it : filter){
            JsonArray jsonArray =  cryptoCurrencyService.getJSONFromURL(createURL(currency, it));
            results.put(it, jsonArray.get(0).getAsJsonObject().get("price").getAsDouble());

        }
        return results;
    }

    private String createURL(String currency, String filter){
        return urlBeginning + "&ids="+currency+"&convert="+filter+urlEnd;
    }
}
