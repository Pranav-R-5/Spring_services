package com.example.personalize.model.entity.vo;


import lombok.Data;

@Data
public class ProductVO {
    private Integer id;

    private String name;

    private double price;

    private int quantity;

    private CategoryVO category;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryVO getCategory() {
        return category;
    }

    public void setCategory(CategoryVO category) {
        this.category = category;
    }

    public void setId(Integer productId) {
        this.id = productId;
    }
}
