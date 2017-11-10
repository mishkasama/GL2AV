package tn.esprit.insurance.managedbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.TypedQuery;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.persistence.Police;
import tn.esprit.insurance.persistence.TypeContract;
import tn.esprit.insurance.persistence.Vehicle;
import tn.esprit.insurance.services.PoliceServiceBean;

@ManagedBean(name="policeBean", eager = true)
@SessionScoped

public class PoliceBean {
	
private int numPolice;
	
	private Date startDate;
	private Date endDate;
	private float price;
	private int points;
	private Insured insured;
	private Vehicle vehicle;
	private TypeContract typeContrat;
	private String user;
	private List<Insured> listInsured;
	
	@EJB
	PoliceServiceBean policeService;
	
	public String addPolice(){
		System.out.println("/n/n/n/n/n************ ");
		System.out.println("************ "+this.points+"/n/n/n/n/n");
		policeService.addPolice(new Police(startDate, endDate, price, points));
		FacesContext.getCurrentInstance().responseComplete();
		return "/pages/admin/gestionEmploye?faces-redirect=true";
	}
	
	
	public List<Insured> getAllInsured(String query) {

		List<Insured> list = policeService.getAllInsured();
		Insured i1 = new Insured("Meriem", "Aboudi");
		Insured i2 = new Insured("Hejer", "Ben ali");
		list.add(i1);
		list.add(i2);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public PoliceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumPolice() {
		return numPolice;
	}

	public void setNumPolice(int numPolice) {
		this.numPolice = numPolice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Insured getSelectedInsured() {
		return insured;
	}

	public void setSelectedInsured(Insured insured) {
		this.insured = insured;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public TypeContract getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContract typeContrat) {
		this.typeContrat = typeContrat;
	}

	public PoliceServiceBean getPoliceService() {
		return policeService;
	}

	public void setPoliceService(PoliceServiceBean policeService) {
		this.policeService = policeService;
	}


















	public String getUser() {
		return user;
	}


















	public void setUser(String user) {
		this.user = user;
	}


















	public List<Insured> getListInsured() {
		listInsured = policeService.getAllInsured();
		return listInsured;
	}


















	public void setListInsured(List<Insured> listInsured) {
		this.listInsured = listInsured;
	}
	
	
	
	
	
	

}
