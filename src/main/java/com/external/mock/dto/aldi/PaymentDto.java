package com.external.mock.dto.aldi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {
    private String cardNumber;
    private String name;
    private String expiryDate;
    private String cvc;
}
