package com.quinbay.springboottraining.controller;


import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.model.PurchaseOrder;
import com.quinbay.springboottraining.orderservice.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/httpmethod")
public class Http_ordercontroller {

    @Autowired
    Orderservice orderservice;

    @GetMapping("/getPurchaseOrders")
    public List<PurchaseOrder> getAllPurchaseOrders(){
        return orderservice.getAllPurchaseOrders();

    }

    @GetMapping("/getCustomerOrder/{customerId}")
    public List<PurchaseOrder> getOrder(@PathVariable Long customerId){
        return orderservice.getPurchaseOrder(customerId);
    }

    @PostMapping("/addPurchaseOrder")
    public String addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
        return orderservice.addPurchaseOrder(purchaseOrder);
    }

    @PostMapping("/purchaseProduct")
    public String purchaseProduct(@RequestBody PurchaseOrder purchaseOrder){
        return orderservice.purchaseProduct(purchaseOrder);
    }


}


