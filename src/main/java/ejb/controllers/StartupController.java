package ejb.controllers;

import ejb.beans.UpdateBean;
import ejb.service.ServiceGet;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
@Startup
@Data
public class StartupController {
    @Inject
    ServiceGet serviceGet;

    @PostConstruct
    private void init() {
        serviceGet.getJsonResponse();

    }
}
