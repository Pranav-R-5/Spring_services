package com.quinbay.springboottraining.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ordershistory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    private long customerId;
    private long productId;
    private long productQuantity;
}
