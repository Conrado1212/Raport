package pl.edu.wszib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.dao.impl.SalesDAOImpl;
import pl.edu.wszib.model.UserReport;
import pl.edu.wszib.rest.ISaleRest;
import pl.edu.wszib.rest.response.UserReportServiceResponse;
import pl.edu.wszib.services.IUserReport;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    SalesDAOImpl salesDAO;

    @Autowired
    IUserReport userReport;

    @Autowired
    ISaleRest saleRest;

    @RequestMapping(value = "/salesReport/{userID}", method = RequestMethod.GET)
    public UserReportServiceResponse salesReport(@PathVariable int userID) {

        UserReport userReport1;

        userReport1= userReport.getUserReportByUserID(userID);
        List<UserReport> result = new ArrayList<>();
        result.add(userReport1);
        System.out.println(result);


        UserReportServiceResponse serviceResponse = new UserReportServiceResponse();
        serviceResponse.setUserReportsList(result);
        System.out.println(result);

        return serviceResponse;
    }
}
