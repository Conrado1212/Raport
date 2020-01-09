package pl.edu.wszib.services.impl;

import pl.edu.wszib.dao.IRaportDAO;
import pl.edu.wszib.model.Raport;
import pl.edu.wszib.services.IRaportService;

public class RaportServiceImpl implements IRaportService {

    IRaportDAO raportDAO;
    public RaportServiceImpl(IRaportDAO raportDAO) {
        this.raportDAO = raportDAO;
    }

    /*
    @Override
    public Raport getRaportByLogin(String login){
        return this.raportDAO.getRaportByLogin(login);
    }

    @Override
    public Raport getRaportByPointOfSales(String pointOfSales){
        return this.raportDAO.getRaportByLogin(pointOfSales);
    }

    @Override
    public Raport getRaportByWhenWasLogged(String whenWasLogged){
        return this.raportDAO.getRaportByLogin(whenWasLogged);
    }*/
}
