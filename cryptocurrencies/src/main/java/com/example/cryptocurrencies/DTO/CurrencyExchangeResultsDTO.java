package com.example.cryptocurrencies.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CurrencyExchangeResultsDTO {
    private String form;
    private List<CurrencyToExchangeDTO> to;
}
