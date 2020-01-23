package pl.edu.wszib.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
@Entity
@Table(name="trepositorypointofsales")
public class RepositoryPointOfSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idPointOfSales;
    private String productName;
    private int amountOfProduct;
    private int priceForOneProduct;
    private int totalPrice;
    private Calendar dateOfSell;

    public  RepositoryPointOfSales(){

    }

    public RepositoryPointOfSales(String idPointOfSales, String productName, int amountOfProduct, int priceForOneProduct) {
        this.idPointOfSales = idPointOfSales;
        this.productName = productName;
        this.amountOfProduct = amountOfProduct;
        this.priceForOneProduct = priceForOneProduct;
        this.totalPrice = amountOfProduct * priceForOneProduct;
        this.dateOfSell = Calendar.getInstance();
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Calendar getDateOfSell() {
        return dateOfSell;
    }

    public void setDateOfSell(Calendar dateOfSell) {
        this.dateOfSell = dateOfSell;
    }

    @Override
    public String toString() {
        return "RepositoryPointOfSales{" +
                "idPointOfSales='" + idPointOfSales + '\'' +
                ", ProductName='" + productName + '\'' +
                ", amountOfProduct=" + amountOfProduct +
                ", priceForOneProduct=" + priceForOneProduct +
                ", totalPrice=" + totalPrice +
                ", dateOfSell=" + dateOfSell +
                '}';
    }

//    public  void vv() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
//        Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
//        System.out.println(sdf.format(calendar.getTime()));
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); // the day of the week in numerical format
//    }
}
