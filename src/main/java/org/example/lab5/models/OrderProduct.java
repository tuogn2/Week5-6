package org.example.lab5.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OrderProduct")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderProduct {
    @Id @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String orderDate;
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public OrderProduct(String orderDate, double quantity, Product product, Person person) {
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.product = product;
        this.person = person;
    }
}
