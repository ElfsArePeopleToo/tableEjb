package ejb.controllers;

import ejb.beans.ConsumerDriver;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.Path;

@Path("updateInfo")
@Stateless
public class UpdateInfo {
    @EJB
    ConsumerDriver consumerDriver;

    public void updateInfo(){
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("update");
    }
}
