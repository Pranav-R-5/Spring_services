package com.quinbay.springboottraining.controller;


import com.quinbay.springboottraining.customerservice.Customerservice;
import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.data.Products;
import com.quinbay.springboottraining.data.PurchaseOrder;
import com.quinbay.springboottraining.model.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/httpmethod")
public class Http_customercontroller {
    @Autowired
    Customerservice customerservice;

//    @GetMapping()
//    public List<Products> get_Productsby_Category(@RequestParam(value = "category") String category){
//        return customerservice.get_Productsby_Category(category);
//    }
    @GetMapping("allproducts")
    public List<Products> get_Allproducts(){
        return customerservice.get_Allproducts();
    }

    @GetMapping("productsbyname")
    public List<Products> get_productsby_name(@RequestParam(value = "name") String name){
        return customerservice.get_productsby_name(name);
    }

    @PostMapping("/addproduct")
    public String addproduct(@RequestBody ProductVO productVO){
        return customerservice.addproduct(productVO);
    }

    @PutMapping("/updateproduct")
    public String putproduct(@RequestBody ProductVO productVO,@RequestParam(value = "id") long id){
        return customerservice.putProduct(productVO,id);
    }

    @DeleteMapping("/deleteproduct")
    public String deleteproduct(@RequestBody ProductVO productVO){
        return customerservice.deleteProduct(productVO);
    }

    @PostMapping("/purchaseProduct")
    public String purchaseProduct(@RequestBody PurchaseOrder purchaseOrder){
        return customerservice.purchaseProduct(purchaseOrder);
    }




}
