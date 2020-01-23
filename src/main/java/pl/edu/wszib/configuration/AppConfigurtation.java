package pl.edu.wszib.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.ISalesDAO;
import pl.edu.wszib.dao.impl.SalesDAOImpl;
import pl.edu.wszib.rest.ISaleRest;
import pl.edu.wszib.rest.impl.salesRest;
import pl.edu.wszib.services.IUserReport;
import pl.edu.wszib.services.impl.UserReportImpl;

@Configuration
public class AppConfigurtation {

    @Bean
    @SessionScope
    public SessionObject sessionObject(){
        return new SessionObject();
    }

    @Bean
    public SessionFactory hibernateSessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public ISalesDAO salesDAO(SessionFactory hibernateSessionFactory) {
        return new SalesDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IUserReport userReport(ISalesDAO salesDAO) {
        return new UserReportImpl(salesDAO);
    }
    @Bean
    public ISaleRest saleRest(ISalesDAO salesDAO) {
        return new salesRest(salesDAO);
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
