package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
}
