package com.quinbay.springboottraining.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.springboottraining.dao.api.ProductRepository;
import com.quinbay.springboottraining.data.Orders;
import com.quinbay.springboottraining.data.Products;
import com.quinbay.springboottraining.data.PurchaseOrder;
import com.quinbay.springboottraining.inventoryservice.Inventoryservice;
import com.quinbay.springboottraining.model.entity.Product;
import com.quinbay.springboottraining.model.vo.ProductVO;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jmx.support.ObjectNameManager;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("inventoryservice")
public class Inventory_service implements Inventoryservice {

    @Autowired
    ProductRepository productRepository;


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;




    @Override
    @Cacheable(value = "springbootTraining",key="#key")
    public String getRedisCache(String key,String value){
        return value;
    }



    @Override
    public List<ProductVO> getProductList(){
        List<Product> productsList=productRepository.findAll();
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.convertValue(productsList,List.class);

    }
    @Override
    public List<ProductVO> get_productby_name(String name){

            List<Product> productList = productRepository.findByName(name);

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.convertValue(productList, List.class);


        }



    @Override
    public String addProduct(@RequestBody ProductVO productVO){
        ObjectMapper objectMapper=new ObjectMapper();
        productRepository.save(objectMapper.convertValue(productVO,Product.class));
        return "added";
    }


    @Override
    public String putProduct(ProductVO productVO,long id) throws JsonProcessingException{

        Optional<Product> productList = productRepository.findById(id);

        ObjectMapper objectMapper = new ObjectMapper();
        Product productUpdate = objectMapper.convertValue(productVO,Product.class);


        if(productList.isEmpty())
            return "not found";

        else {
            Product product = productList.get();
            product.setId(productUpdate.getId());
            product.setName(productUpdate.getName());
            if(product.getPrice()>productUpdate.getPrice())PriceDrop(product);
            product.setPrice(productUpdate.getPrice());
            product.setQuantity(productUpdate.getQuantity());
            product.setCategory(productUpdate.getCategory());
            productRepository.save(product);
        }

        return "Done";

    }

    @Override
    public String deleteProduct(ProductVO productVO){
        ObjectMapper objectMapper=new ObjectMapper();
        productRepository.delete(objectMapper.convertValue(productVO,Product.class));
        return "deleted";

    }

    @Override
    public String purchaseProduct(PurchaseOrder purchaseOrder){
        ObjectMapper objectMapper=new ObjectMapper();
        Product product=productRepository.findById(purchaseOrder.getProductId()).get();

        if(product.getQuantity()>purchaseOrder.getProductQuantity()){
            product.setQuantity((int)product.getQuantity()-purchaseOrder.getProductQuantity());
            productRepository.save(product);
            return "Item Available";
        }
        return "Item not Available";
    }

    @Override
    public void PriceDrop(Product prod) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        kafkaTemplate.send("com.quinbay.product.create", objectMapper.writeValueAsString(prod));
    }
//
//    @Override
//    public List<Products> get_Productsby_Category(String category) {
//
//        List<Products> productList = new ArrayList<>();
//        List<Products> result = new ArrayList<>();
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getCategory().equals(category)) {
//                result.add(productList.get(i));
//
//
//            }
//        }
//        return result;
//    }
//


}
