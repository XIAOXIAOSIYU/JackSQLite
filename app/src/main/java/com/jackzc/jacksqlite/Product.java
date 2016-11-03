package com.jackzc.jacksqlite;

public class Product {
    private int _product_id;
    private String _product_name;

    //Added this empty constructor in lesson 50 in case we ever want to create the object and assign it later.
    public Product() {

    }

    public Product(String productName) {

        this._product_name = productName;
    }

    public int get_product_id() {

        return _product_id;
    }

    public void set_product_id(int _id) {

        this._product_id = _id;
    }

    public String get_product_name() {

        return _product_name;
    }

    public void set_product_name(String _product_name) {
        this._product_name = _product_name;
    }
}