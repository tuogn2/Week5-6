package org.example.lab5.models;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "person")
@Getter @Setter  @NoArgsConstructor @ToString
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long id;
    private String name;
    private String gender;
    private String address;
    private String phone;
    private String email;


    public Person(String name, String gender, String address, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
