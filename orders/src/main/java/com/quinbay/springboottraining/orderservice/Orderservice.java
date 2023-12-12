package com.quinbay.springboottraining.orderservice;

import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.model.PurchaseOrder;

import java.util.List;

public interface Orderservice {

    List<PurchaseOrder> getAllPurchaseOrders();

    String addPurchaseOrder(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> getPurchaseOrder(long customerId);
    String purchaseProduct(PurchaseOrder purchaseOrder);
}
