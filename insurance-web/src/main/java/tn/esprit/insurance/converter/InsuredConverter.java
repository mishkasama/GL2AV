package tn.esprit.insurance.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.services.PoliceServiceBean;

@FacesConverter("insuredConverter")
public class InsuredConverter implements Converter{
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	PoliceServiceBean service = (PoliceServiceBean) fc.getExternalContext().getApplicationMap().get("policeBean");
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
			StringBuffer strbuff=new StringBuffer(user.getIdInsured());
			String userstr=strbuff.toString();
            return userstr;
        }
        else {
            return null;
        }
    }   

}
