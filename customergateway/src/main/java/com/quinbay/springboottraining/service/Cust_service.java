package com.quinbay.springboottraining.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.springboottraining.customerservice.Customerservice;
import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.data.Products;
import com.quinbay.springboottraining.data.PurchaseOrder;
import com.quinbay.springboottraining.model.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

@Service ("Customerservice")
public class Cust_service implements Customerservice {

        @Autowired
        RestTemplate restTemplate;


    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

//    @Override
//    public void sendMessage(String msg){
//        kafkaTemplate.send("com.quinbay.product.create",msg);
//    }
//
//

    private String inventory_Url = "http://localhost:8005/httpmethod";
    private String order_Url ="http://localhost:8002/httpmethod";

//    private String orders_Url = "http://localhost:8002/httpmethods";


//    @Override
//    public void sendMessage(Orders orders)throws JsonProcessingException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        kafkaTemplate.send("com.quinbay.product.create",objectMapper.writeValueAsString(orders));
//    }

//    @Override
//    public List<Products> get_Productsby_Category(String category) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        UriComponents builder = UriComponentsBuilder.fromHttpUrl(inventory_Url + "/products").queryParam("category", category).build();
//
//        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();
//
//    }


    @Override
    public List<Products> get_Allproducts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(inventory_Url + "/allproducts").build();

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();

    }

    @Override
    public List<Products> get_productsby_name(String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(inventory_Url + "/productsbyname").queryParam("name",name).build();

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();

    }

    @Override
    public String addproduct(ProductVO products){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity= new HttpEntity(products,headers);


        return restTemplate.exchange(inventory_Url+"/addproduct", HttpMethod.POST, entity, String.class).getBody();
    }

    @Override
    public String putProduct(ProductVO productVO,long id){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProductVO> entity= new HttpEntity(productVO,headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(inventory_Url + "/updateproduct").queryParam("id",id).build();

        return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, String.class).getBody();


    }

    @Override
    public String deleteProduct(ProductVO productVO){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity= new HttpEntity(productVO,headers);


        return restTemplate.exchange(inventory_Url+"/deleteproduct", HttpMethod.DELETE, entity, String.class).getBody();

    }

    public String purchaseProduct(PurchaseOrder purchaseOrder){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> entity= new HttpEntity(purchaseOrder,headers);
        return restTemplate.exchange(order_Url+"/purchaseProduct",HttpMethod.POST,entity,String.class).getBody();
    }




//    @Override
//    public List<Products> add_Productdetails(Products products){
//        HttpHeaders headers=new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> entity= new HttpEntity(products,headers);
//
//
//        return restTemplate.exchange(inventory_Url+"add", HttpMethod.POST, entity, List.class).getBody();
//    }
//
//    @Override
//    public List<Products> update_Details(int p_Id,Products products){
//
//        HttpHeaders headers=new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> entity= new HttpEntity(products,headers);
//
//
//        return restTemplate.exchange(inventory_Url+"update", HttpMethod.PUT, entity, List.class).getBody();
//
//
//    }
//
//    @Override
//    public List<Products> delete_Details(int p_Id){
//
//        HttpHeaders headers=new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> entity= new HttpEntity(headers);
//
//
//        return restTemplate.exchange(inventory_Url+"delete", HttpMethod.DELETE, entity, List.class).getBody();
//
//    }
//
//    @Override
//    public List<Orders> get_Orders(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        UriComponents builder = UriComponentsBuilder.fromHttpUrl(orders_Url + "/orders").build();
//
//        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();
//
//    }
//
//    @Override
//    public String place_Order(Orders orders){
//        HttpHeaders headers=new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> entity= new HttpEntity(orders,headers);
//
//
//        return restTemplate.exchange(inventory_Url+"/placeorder", HttpMethod.POST, entity, String.class).getBody();
//


//        return restTemplate.exchange(orders_Url+"placeorder", HttpMethod.POST, entity, String.class).queryParam("p_id",p_id).getBody();
//    }
    }


