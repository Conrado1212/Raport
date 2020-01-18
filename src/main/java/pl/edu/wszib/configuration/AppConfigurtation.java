package pl.edu.wszib.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.SessionObject;

@Configuration
public class AppConfigurtation {

    @Bean
    @SessionScope
    public SessionObject sessionObject(){
        return new SessionObject();
    }

    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
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
