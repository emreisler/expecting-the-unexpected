package com.example.expectingtheunexpected.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    @NotNull
    private String orderId;
    @NotNull
    private String customerId;
    @NotNull
    private String productId;
    @NotNull
    private long quantity;
}
