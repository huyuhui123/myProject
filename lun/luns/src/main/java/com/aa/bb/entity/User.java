package com.aa.bb.entity;

import lombok.Data;

@Data
public class User {
    public Integer id;
    public String name;

    public User(String name) {
        this.name = name;
    }
}
