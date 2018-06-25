package ejb.controllers;

import ejb.beans.ConsumerDriver;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("updateInfo")
@Stateless
public class UpdateInfo {
    @EJB
    ConsumerDriver consumerDriver;

    public void updateInfo(){
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("update");
    }
}
