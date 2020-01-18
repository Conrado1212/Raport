package pl.edu.wszib.model;

public class Product {
    private String idPointOfSales;
    private String productName;
    private int amountOfProduct;
    private int priceForOneProduct;

    public Product(String idPointOfSales, String productName, int amountOfProduct, int priceForOneProduct) {
        this.idPointOfSales = idPointOfSales;
        this.productName = productName;
        this.amountOfProduct = amountOfProduct;
        this.priceForOneProduct = priceForOneProduct;
    }

    public String getIdPointOfSales() {
        return idPointOfSales;
    }

    public void setIdPointOfSales(String idPointOfSales) {
        this.idPointOfSales = idPointOfSales;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    public void setAmountOfProduct(int amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

    public int getPriceForOneProduct() {
        return priceForOneProduct;
    }

    public void setPriceForOneProduct(int priceForOneProduct) {
        this.priceForOneProduct = priceForOneProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idPointOfSales='" + idPointOfSales + '\'' +
                ", productName='" + productName + '\'' +
                ", amountOfProduct=" + amountOfProduct +
                ", priceForOneProduct=" + priceForOneProduct +
                '}';
    }
}
