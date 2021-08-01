package com.example.cryptocurrencies.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExchangeRatesDTO {
    private String source;
    private Map<String, Double> rates;
}
