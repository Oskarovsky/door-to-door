package com.oskarro.doortodoor.model;

public class Product {

    private ProductType productType;
    private Owner owner;

    private String name;
    private String productId;
    private String description;
    private String size;
    private String price;
    private String imageUrl;
    private String endLocalization;
    private String startLocalization;

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEndLocalization() {
        return endLocalization;
    }

    public void setEndLocalization(String endLocalization) {
        this.endLocalization = endLocalization;
    }

    public String getStartLocalization() {
        return startLocalization;
    }

    public void setStartLocalization(String startLocalization) {
        this.startLocalization = startLocalization;
    }
}
