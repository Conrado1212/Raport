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

public class RepositoryPointOfSalesDAOImpl implements IRepositoryPointOfSalesDAO {
    @Autowired
    SessionFactory sessionFactory;


    public RepositoryPointOfSalesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProductAfterSale(RepositoryPointOfSales repositoryPointOfSales) { //adding product after sale
        Session session;
        Transaction tx = null;

        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(repositoryPointOfSales);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public List<RepositoryPointOfSales> getProductsFromRepository() {  // return  list of products grouped by idPointOfSales and productName, with sum amount and totalPrice
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listProductsFromRepository = session
                .createQuery("SELECT R.idPointOfSales, R.productName, SUM(R.amountOfProduct), R.priceForOneProduct, SUM(R.totalPrice) FROM pl.edu.wszib.model.RepositoryPointOfSales R " +
                        "GROUP BY R.idPointOfSales, R.productName")
                .list();
        session.close();
        return listProductsFromRepository;
    }

    @Override
    public List<RepositoryPointOfSales> getSalesWithDateFromRepository() {  // return all sales without group by , with date
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listSalesWithDateFromRepository = session
                .createQuery("FROM pl.edu.wszib.model.RepositoryPointOfSales")
                .list();
        session.close();
        return listSalesWithDateFromRepository;
    }

    @Override
    public List<RepositoryPointOfSales> getSalesWithDateFromRepositoryByPoint(int idPointOfSales) {// return all sales from pointOfSales , with date
        Session session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listSalesWithDateFromRepositoryByPoint = session
                .createQuery("Select idPointOfSales, productName,amountOfProduct, priceForOneProduct,totalPrice, dateOfSell FROM pl.edu.wszib.model.RepositoryPointOfSales R WHERE  R.idPointOfSales = '" + idPointOfSales + "'")
                .list();
        session.close();

        return listSalesWithDateFromRepositoryByPoint;
    }

    @Override
    public List<RepositoryPointOfSales> getProductsFromRepositoryByPoint(int idPointOfSales) {// return  list of products from pointOfSales grouped by idPointOfSales and productName, with sum amount and totalPrice
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listProductsFromRepositoryByPoint = session
                .createQuery("Select R.idPointOfSales, R.productName, SUM(R.amountOfProduct), R.priceForOneProduct, SUM(R.totalPrice) FROM pl.edu.wszib.model.RepositoryPointOfSales R " +
                        "WHERE R.idPointOfSales = '" + idPointOfSales + "' GROUP BY R.idPointOfSales, R.productName")
                .list();
        session.close();

        return listProductsFromRepositoryByPoint;
    }

    @Override
    public List<RepositoryPointOfSales> averageOfDay(int idPointOfSales, Calendar firstDay, Calendar secondDay) {
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listAverageOfDayFromRepositoryByPoint = session
                .createQuery("SELECT idPointOfSales, AVG(totalPrice) AS totalPricePerDay, dateOfSell, " +
                        "AVG(SELECT  AVG(totalPrice) FROM pl.edu.wszib.model.RepositoryPointOfSales WHERE idPointOfSales = '" + idPointOfSales + "' AND dateOfSell between '" + firstDay.get(Calendar.YEAR) + "'-'" + firstDay.get(Calendar.MONTH) + "'-'" + firstDay.get(Calendar.DAY_OF_MONTH) + "' 00:00:00' and '" +
                        +secondDay.get(Calendar.YEAR) + "'-'" + secondDay.get(Calendar.MONTH) + "'-'" + secondDay.get(Calendar.DAY_OF_MONTH) + "' 23:59:00' GROUP BY idPointOfSales, day(dateOfSell))) AS averagePerDay" +
                        "  FROM pl.edu.wszib.model.RepositoryPointOfSales " +
                        "WHERE idPointOfSales = '" + idPointOfSales + "' AND dateOfSell between '" + firstDay.get(Calendar.YEAR) + "'-'" + firstDay.get(Calendar.MONTH) + "'-'" + firstDay.get(Calendar.DAY_OF_MONTH) + "' 00:00:00' and '"
                        + secondDay.get(Calendar.YEAR) + "'-'" + secondDay.get(Calendar.MONTH) + "'-'" + secondDay.get(Calendar.DAY_OF_MONTH) + "' 23:59:00' " +
                        " GROUP BY idPointOfSales, day(dateOfSell)")
                .list();
        session.close();

        return listAverageOfDayFromRepositoryByPoint;

    }

    @Override
    public List<RepositoryPointOfSales> averageOfMonth(int idPointOfSales, Calendar firstMonth, Calendar secondMonth) {
        Session session;
        session = this.sessionFactory.openSession();
        List<RepositoryPointOfSales> listAverageOfMonthFromRepositoryByPoint = session
                .createQuery("SELECT idPointOfSales, AVG(totalPrice) AS averagePrice, dateOfSell, " +
                        "AVG(SELECT AVG(totalPrice)  FROM pl.edu.wszib.model.RepositoryPointOfSales " +
                        "WHERE idPointOfSales = '" + idPointOfSales + "' AND dateOfSell between '" + firstMonth.get(Calendar.YEAR) + "'-'" + firstMonth.get(Calendar.MONTH) + "'-00 00:00:00' and '"
                        + secondMonth.get(Calendar.YEAR) + "'-'" + secondMonth.get(Calendar.MONTH) + "'-31 23:59:00' " + " GROUP BY idPointOfSales, month(dateOfSell))) AS averagePerMonth" +
                        "FROM pl.edu.wszib.model.RepositoryPointOfSales " +
                        "WHERE idPointOfSales = '" + idPointOfSales + "' AND dateOfSell between '" + firstMonth.get(Calendar.YEAR) + "'-'" + firstMonth.get(Calendar.MONTH) + "'-00 00:00:00' and '"
                        + secondMonth.get(Calendar.YEAR) + "'-'" + secondMonth.get(Calendar.MONTH) + "'-31 23:59:00' " +
                        " GROUP BY idPointOfSales, month(dateOfSell)")
                .list();
        session.close();

        return listAverageOfMonthFromRepositoryByPoint;
    }
}
