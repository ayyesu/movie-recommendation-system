package com.recommendation.system.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Add any other genre-related attributes here

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Add getters and setters for other attributes
}

