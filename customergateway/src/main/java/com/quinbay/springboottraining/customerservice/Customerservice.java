package com.quinbay.springboottraining.customerservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.data.Products;
import com.quinbay.springboottraining.data.PurchaseOrder;
import com.quinbay.springboottraining.model.vo.ProductVO;

import java.util.List;

public interface Customerservice {
//    List<Products> get_Productsby_Category(String category);

    List<Products> get_Allproducts();
    List<Products> get_productsby_name(String name);
    String addproduct(ProductVO products);
    String putProduct(ProductVO productVO,long id);
    String deleteProduct(ProductVO productVO);
    String purchaseProduct(PurchaseOrder purchaseOrder);

//    List<Products> add_Productdetails(Products products);
//
//    List<Products> update_Details(int p_Id, Products products);
//
//    List<Products> delete_Details(int p_Id);
//
//    List<Orders> get_Orders();
//
//    String place_Order(Orders orders);
//
//    void sendMessage(Orders orders) throws JsonProcessingException;

}
