package pl.edu.wszib.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.IRepositoryPointOfSalesDAO;
import pl.edu.wszib.dao.impl.RepositoryPointOfSalesDAOImpl;
import pl.edu.wszib.services.IRepositoryPointOfSalesService;
import pl.edu.wszib.services.impl.RepositoryPointOfSalesServiceImpl;

@Configuration
public class AppConfigurtation {

    @Bean
    @SessionScope
    public SessionObject sessionObject(){
        return new SessionObject();
    }

    @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }


    @Bean
    public IRepositoryPointOfSalesDAO repositoryPointOfSalesDAO(SessionFactory hibernateSessionFactory){
        return new RepositoryPointOfSalesDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IRepositoryPointOfSalesService repositoryPointOfSalesService(IRepositoryPointOfSalesDAO repositoryPointOfSalesDAO){
        return new RepositoryPointOfSalesServiceImpl(repositoryPointOfSalesDAO);
    }
   /* @Bean
    @Bean
    public IRaportDAO raportDAO(SessionFactory hibernateSessionFactory){
        return new RaportDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IRaportService raportService(IRaportDAO raportDAO){
        return  new RaportServiceImpl(raportDAO);

    }*/
}
