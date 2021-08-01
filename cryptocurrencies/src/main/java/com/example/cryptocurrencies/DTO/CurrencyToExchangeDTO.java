package com.example.cryptocurrencies.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CurrencyToExchangeDTO {
    private String name;
    private Double rate;
    private Integer amount;
    private Double result;
    private Double fee;
}
