package com.quinbay.springboottraining.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    private long customerId;
    private long productId;
    private long productQuantity;
}