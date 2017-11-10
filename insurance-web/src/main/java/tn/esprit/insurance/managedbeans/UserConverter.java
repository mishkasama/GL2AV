package tn.esprit.insurance.managedbeans;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.services.PoliceServiceBean;
 

 
@ManagedBean
public class UserConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	PoliceServiceBean service = (PoliceServiceBean) fc.getExternalContext().getApplicationMap().get("PoliceBean");
                return service.getAllInsured().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {

    			Insured user=(Insured)object;
    			StringBuffer strbuff=new StringBuffer(user.getFirstName());
    			String userstr=strbuff.toString();
    			return userstr;
    		}

      
        else {
            return null;
        }
    }

	  
}         