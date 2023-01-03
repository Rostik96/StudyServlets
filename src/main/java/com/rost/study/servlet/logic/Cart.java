package com.rost.study.servlet.logic;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private String name;
    private int quantity;

    public static void main(String[] args) {
        int x = 0;
        System.out.println(Optional.of(x).orElse(322));
    }
}
