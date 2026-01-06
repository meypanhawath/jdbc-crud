package model;

public class Product {
    private Integer id;
    private String code;
    private String name;
    private Double price;
    private Integer qty;
    private Boolean isDeleted;

    public Product(String code, String name, Double price, Integer qty, Boolean isDeleted) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.isDeleted = isDeleted;
    }

    public Product(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
