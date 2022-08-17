package com.bchen.Fragrance.model;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name = "product_inventory")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "price")
    private double retailPrice;
    @Column(name="scent_type")
    private String scentType;
    @Column(name="description")
    private String description;



}
