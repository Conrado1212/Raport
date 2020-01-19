package pl.edu.wszib.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import pl.edu.wszib.dao.IRaportDAO;
import pl.edu.wszib.model.Raport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RaportDAOImpl implements IRaportDAO {

    private List<Raport> raports = new ArrayList<>();

    public RaportDAOImpl(){
        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println("Current Date: " + ft.format(dNow));

        Raport raport1 = new Raport();
        raport1.setLogin("Mateusz");
        raport1.setPointOfSales("point1");
        raport1.setWhenWasLogged( ft.format(dNow));

        Raport raport2 = new Raport();
        raport2.setLogin("Piotr");
        raport2.setPointOfSales("point2");
        raport2.setWhenWasLogged(  ft.format(dNow));

        Raport raport3 = new Raport();
        raport3.setLogin("Paweł");
        raport3.setPointOfSales("point3");
        raport3.setWhenWasLogged(  ft.format(dNow));


        Raport raport4 = new Raport();
        raport4.setLogin("Jan");
        raport4.setPointOfSales("point4");
        raport4.setWhenWasLogged( ft.format(dNow));

        this.raports.add(raport1);
        this.raports.add(raport2);
        this.raports.add(raport3);
        this.raports.add(raport4);
    }

    @Override
    public List<Raport> getAllRaport(){
        return raports;
    }


    SessionFactory sessionFactory;

    public RaportDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveRaport(Raport raport){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(raport);
            tx.commit();
            session.close();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx != null )tx.rollback();
        }
    }

    @Override
    public Raport getRaportByLogin(String login){
        Session session = this.sessionFactory.openSession();
        Raport raport = (Raport) session
                .createQuery("FROM pl.edu.wszib.model.Raport WHERE login " + login + "").uniqueResult();
        session.close();
        return raport;
    }

    @Override
    public Raport getRaportByPointOfSales(String pointOfSales){
        Session session = this.sessionFactory.openSession();
        Raport raport = (Raport) session
                .createQuery("FROM pl.edu.wszib.Raport WHERE pointOfSales " + pointOfSales + "").uniqueResult();
        session.close();
        return raport;
    }

    @Override
    public Raport getRaportByWhenWasLogged(String whenWasLogged){
        Session session = this.sessionFactory.openSession();
        Raport raport = (Raport) session
                .createQuery("FROM pl.edu.wszib.Raport " + whenWasLogged + "").uniqueResult();
        session.close();
        return raport;
    }

    @Override
    public List<Raport> getAllRaports(){
        Session session = sessionFactory.openSession();
        List<Raport> raports = session.createQuery("FROM pl.edu.wszib.model.Raport").list();
        session.close();
        return raports;
    }
}
