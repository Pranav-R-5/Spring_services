package com.quinbay.springboottraining.dao.api;

import com.quinbay.springboottraining.model.PurchaseOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository  extends MongoRepository<PurchaseOrder,Long>{
    List<PurchaseOrder> findByCustomerId(long customerId);
}
