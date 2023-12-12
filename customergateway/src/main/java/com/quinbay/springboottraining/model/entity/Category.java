package com.quinbay.springboottraining.model.entity;


import com.quinbay.springboottraining.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name=FieldNames.CATEGORY_T)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name=FieldNames.ID,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name=FieldNames.NAME,nullable = false)
    private String name;
//
////    @OneToMany
////    @JoinColumn(name=FieldNames.PRODUCT_ID,nullable = false)
//        private Product product;
    }



