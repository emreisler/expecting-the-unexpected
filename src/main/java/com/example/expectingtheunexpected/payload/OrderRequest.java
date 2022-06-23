package com.example.expectingtheunexpected.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrderRequest {
    @NotNull
    private String customerId;
    @NotNull
    private String productId;
    @NotNull
    private long quantity;
}
