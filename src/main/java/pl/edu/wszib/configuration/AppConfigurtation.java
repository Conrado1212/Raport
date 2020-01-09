package pl.edu.wszib.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.dao.IRaportDAO;
import pl.edu.wszib.dao.impl.RaportDAOImpl;
import pl.edu.wszib.services.IRaportService;
import pl.edu.wszib.services.impl.RaportServiceImpl;

@Configuration
public class AppConfigurtation {
   /* @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public IRaportDAO raportDAO(SessionFactory hibernateSessionFactory){
        return new RaportDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IRaportService raportService(IRaportDAO raportDAO){
        return  new RaportServiceImpl(raportDAO);

    }*/
}
