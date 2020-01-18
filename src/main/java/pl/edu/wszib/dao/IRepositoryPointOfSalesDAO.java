package pl.edu.wszib.dao;

import pl.edu.wszib.model.RepositoryPointOfSales;

import java.util.Calendar;
import java.util.List;

public interface IRepositoryPointOfSalesDAO {
    void addProductAfterSale(RepositoryPointOfSales repositoryPointOfSales); //adding product after sale


    List<RepositoryPointOfSales> getAllProductsFromRepository(); // return  list of products grouped by idPointOfSales and productName and sum amount and totalPrice
    List<RepositoryPointOfSales> getAllSalesWithDateFromRepository(); // return all sales without group by with date
    List<RepositoryPointOfSales> getAllSalesWithDateFromRepositoryByPoint(String idPointOfSales); // return all sales from pointOfSales without group by, with date
    List<RepositoryPointOfSales> getAllProductsFromRepositoryByPoint(String idPointOfSales); // return  list of products from pointOfSales grouped by idPointOfSales and productName and sum amount and totalPrice

    void averageOfDay(String idPointOfSales, Calendar firstDay, Calendar secondDay);
    void averageOfMonth(String idPointOfSales, Calendar firstMonth, Calendar secondMonth);

}
