package com.quinbay.springboottraining.dao.api;

import com.quinbay.springboottraining.model.entity.Product;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {
    @Override
    List<Product> findAll();

    @Override
    Product save(Product entity);
    List<Product> findByName(String name);

    @Override
    void delete(Product entity);




}
