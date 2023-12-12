package com.quinbay.springboottraining.inventoryservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.data.Products;
import com.quinbay.springboottraining.data.PurchaseOrder;
import com.quinbay.springboottraining.model.entity.Product;
import com.quinbay.springboottraining.model.vo.ProductVO;

import java.util.List;

public interface Inventoryservice {

    List<ProductVO> getProductList();

    List<ProductVO> get_productby_name(String name);

    String addProduct(ProductVO productVO);

    String putProduct(ProductVO productVO,long id) throws JsonProcessingException;

    String deleteProduct(ProductVO productVO);

    String purchaseProduct(PurchaseOrder purchaseOrder);

    public void PriceDrop(Product product) throws JsonProcessingException;
//    String sendmessage(Orders order);

      String getRedisCache(String key,String value);

}
