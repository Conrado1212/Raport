package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IRepositoryPointOfSalesDAO;
import pl.edu.wszib.model.RepositoryPointOfSales;

import java.util.Calendar;
import java.util.List;

public class RepositoryPointOfSalesImpl implements IRepositoryPointOfSalesDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addProductAfterSale(RepositoryPointOfSales repositoryPointOfSales) { //adding product after sale
        Session session;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(repositoryPointOfSales);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public List<RepositoryPointOfSales> getAllProductsFromRepository() {   // return  list of products grouped by idPointOfSales and productName and sum amount and totalPrice
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listAllProductsFromRepository = session
                .createSQLQuery("SELECT idPointOfSales, productName, SUM(amountOfProduct), priceForOneProduct, SUM(totalPrice) FROM pl.edu.wszib.model.RepositoryPointOfSales " +
                        "GROUP BY idPointOfSales, productName")
                .list();
        session.close();
        return listAllProductsFromRepository;
    }

    @Override
    public List<RepositoryPointOfSales> getAllSalesWithDateFromRepository() {  // return all sales without group by with date
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listAllSalesWithDateFromRepository = session
                .createSQLQuery("SELECT * FROM pl.edu.wszib.model.RepositoryPointOfSales GROUP BY idPointOfSales, productName")
                .list();
        session.close();
        return listAllSalesWithDateFromRepository;
    }

    @Override
    public List<RepositoryPointOfSales> getAllSalesWithDateFromRepositoryByPoint(String idPointOfSales) {// return all sales from pointOfSales without group by, with date
        Session session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listAllSalesWithDateFromRepositoryByPoint = session
                .createQuery("FROM pl.edu.wszib.model.RepositoryPointOfSales WHERE ")
                .list();
        session.close();

        return listAllSalesWithDateFromRepositoryByPoint;
    }

    @Override
    public List<RepositoryPointOfSales> getAllProductsFromRepositoryByPoint(String idPointOfSales) {// return  list of products from pointOfSales grouped by idPointOfSales and productName and sum amount and totalPrice
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listAllProductsFromRepositoryByPoint = session
                .createSQLQuery("SELECT idPointOfSales, productName, SUM(amountOfProduct), priceForOneProduct, SUM(totalPrice) FROM pl.edu.wszib.model.RepositoryPointOfSales " +
                        "WHERE idPointOfSales = '"+idPointOfSales+"' GROUP BY idPointOfSales, productName")
                .list();
        session.close();

        return listAllProductsFromRepositoryByPoint;
    }

    @Override
    public void averageOfDay(String idPointOfSales, Calendar firstDay, Calendar secondDay) {

    }

    @Override
    public void averageOfMonth(String idPointOfSales, Calendar firstMonth, Calendar secondMonth) {

    }
}
