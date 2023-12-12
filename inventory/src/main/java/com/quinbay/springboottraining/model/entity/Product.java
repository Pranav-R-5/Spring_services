package com.quinbay.springboottraining.model.entity;


import com.quinbay.springboottraining.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.quinbay.springboottraining.model.entity.Category;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name=FieldNames.PRODUCT_T)
public class Product {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Id
    @Column(name=FieldNames.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name=FieldNames.NAME,nullable = false)
    private String name;


    @Column(name=FieldNames.PRICE,nullable = false)
    private long price;


    @Column(name=FieldNames.QUANTITY,nullable = false)
    private long quantity;


    @ManyToOne
    @JoinColumn(name=FieldNames.CATEGORY_ID,nullable = false)
    private Category category;


}
