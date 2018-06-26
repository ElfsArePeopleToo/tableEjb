package ejb.controllers;

import ejb.service.ServiceGet;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateless;
@Stateless
@Startup
public class StartupController {
    @EJB
    ServiceGet serviceGet;

    @PostConstruct
    private void init() {
       serviceGet.getJsonResponse();
    }
}
