package com.quinbay.springboottraining.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.springboottraining.dao.api.OrderRepository;
import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.model.PurchaseOrder;
import com.quinbay.springboottraining.orderservice.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Service("orderservice")
public class Order_Service implements Orderservice {


    private String inventory_Url = "http://localhost:8005/httpmethod";

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return orderRepository.findAll();

    }

    @Override
    public String addPurchaseOrder(PurchaseOrder purchaseOrder) {
        orderRepository.save(purchaseOrder);
        return "Sucessful";
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrder(long customerId) {
        ObjectMapper objectMapper = new ObjectMapper();

        List<PurchaseOrder> result = objectMapper.convertValue(orderRepository.findByCustomerId(customerId), List.class);
        return result;
    }

    @Override
    public String purchaseProduct(PurchaseOrder purchaseOrder) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PurchaseOrder> entity = new HttpEntity<>(purchaseOrder, headers);
        System.out.println(purchaseOrder.getProductQuantity());
        orderRepository.save(purchaseOrder);

        String orderResponse = restTemplate.exchange(inventory_Url + "/purchaseProduct", HttpMethod.POST, entity, String.class).getBody();
        if (orderResponse.equals("Item Available")) {
            return "Order placed...";
        }
        return "Not available";


    }
}