package com.example.springbootdemo2.bean;

public class Cat {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public Cat() {
    }

    public Cat(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
