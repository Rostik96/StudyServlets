package com.rost.study.servlet.logic;

public class TestClass {
    public String getInfo() {
        return String.format("This string returned from %s class.", this.getClass().getSimpleName());
    }
}
