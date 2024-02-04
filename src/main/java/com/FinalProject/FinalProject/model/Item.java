package com.FinalProject.FinalProject.model;

public class Item {
    private Long id;
    private String name;
    private int price;
    private String image;
    private Long inStock;
    public Item() {
    }
    public Item(Long id, String name, int price, String image, Long inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.inStock = inStock;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getInStock() {
        return inStock;
    }

    public void setInStock(Long in_stock) {
        this.inStock = in_stock;
    }
}
