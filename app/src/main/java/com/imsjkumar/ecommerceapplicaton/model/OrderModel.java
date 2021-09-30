package com.imsjkumar.ecommerceapplicaton.model;

public class OrderModel {
    int orderImage;
    String orderproductName;
    String price;
    String orderNumber;
    public OrderModel() {
        this.orderImage = orderImage;
        this.orderproductName = orderproductName;
        this.price = price;
        this.orderNumber = orderNumber;
    }


    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderproductName() {
        return orderproductName;
    }

    public void setOrderproductName(String orderproductName) {
        this.orderproductName = orderproductName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }



}
