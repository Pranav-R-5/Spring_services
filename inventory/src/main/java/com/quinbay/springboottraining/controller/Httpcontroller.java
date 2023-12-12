package com.quinbay.springboottraining.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.data.Products;
import com.quinbay.springboottraining.data.PurchaseOrder;
import com.quinbay.springboottraining.inventoryservice.Inventoryservice;
import com.quinbay.springboottraining.model.entity.Category;
import com.quinbay.springboottraining.model.entity.Product;
import com.quinbay.springboottraining.model.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/httpmethod")
public class Httpcontroller {
    @Autowired
    Inventoryservice inventoryservice;


    @GetMapping("/allproducts")
    public List<ProductVO> getProductDetails(){
        return inventoryservice.getProductList();
    }


    @GetMapping("/productsbyname")
    public List<ProductVO> get_productsby_Id(@RequestParam(value = "name") String name){
        return inventoryservice.get_productby_name(name);
    }

    @PostMapping("/addproduct")
     public String addproduct(@RequestBody ProductVO p){
                return inventoryservice.addProduct(p);
    }

    @PutMapping("/updateproduct")
    public String putproduct(@RequestBody ProductVO productVO,@RequestParam(value = "id") long id) throws JsonProcessingException{
        return inventoryservice.putProduct(productVO,id);
    }

    @DeleteMapping("/deleteproduct")
    public String deleteproduct(@RequestBody ProductVO productVO){
        return inventoryservice.deleteProduct(productVO);
    }

    @PostMapping("/purchaseProduct")
    public String purchaseProduct(@RequestBody PurchaseOrder purchaseOrder){
        return inventoryservice.purchaseProduct(purchaseOrder);
    }

    @PostMapping("/publish")
    public void publishKafka(@RequestBody Product product) throws JsonProcessingException {
        inventoryservice.PriceDrop(product);
    }


    @GetMapping("/rediscache")
    public String getRedisCache(@RequestParam(value = "key")String key,@RequestParam(value = "value")String value){
        return inventoryservice.getRedisCache(key,value);
    }

//    @PostMapping("/publish")
//    public String sendmessage(Orders order){
//        return inventoryservice.sendmessage(order);
//    }



//    @GetMapping("/products")
//    public List<Products> get_Productsby_Category(@RequestParam(value = "category") String category){
//        return inventoryservice.get_Productsby_Category(category);
//    }
//



}
