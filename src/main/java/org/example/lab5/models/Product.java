package org.example.lab5.models;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "product")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {

    @Id @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private double price;
    private int quantity;
}
