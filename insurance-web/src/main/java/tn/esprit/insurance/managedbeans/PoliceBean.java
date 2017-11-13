package tn.esprit.insurance.managedbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.TypedQuery;

import org.primefaces.context.RequestContext;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.persistence.Police;
import tn.esprit.insurance.persistence.TypeContract;
import tn.esprit.insurance.persistence.Vehicle;
import tn.esprit.insurance.services.PoliceServiceBean;

@ManagedBean(name="policeBean")
@ViewScoped
public class PoliceBean {
	
private int numPolice;
	
	private Date startDate;
	private Date endDate;
	private float price;
	private int points;
	private Insured insured;

	private int selectedInsureId;
	private int selectedVehicleId;
	private int selectedTypeContactId;
	private Vehicle vehicle;
	private TypeContract typeContrat;
	private String user;
	private List<Insured> listInsured;
	private List<Vehicle> listVehicle;
	private List<TypeContract> listTypeContract;
	private List<Police> listContract;
	private Police contract;
	private Police police;
	public boolean state;
	private int id;
	
	@EJB
	PoliceServiceBean policeService;
	

	
	
	public String addContract(){
		System.out.println("startDate: ++");
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("selectedInsureId: "+selectedInsureId);
		System.out.println("startDate: "+simpleFormat.format(startDate));
		System.out.println("endDate: "+simpleFormat.format(endDate));
		Police c = new Police((Date) startDate, (Date)  endDate,(Date) startDate, price, 8);

		Insured ins = new Insured();
		Vehicle vehicle = new Vehicle();
		TypeContract tpc = new TypeContract();
		
		vehicle = policeService.getVehicleById(selectedVehicleId);
		tpc = policeService.getTypeContractById(selectedTypeContactId);
		ins = policeService.getInsuredById(selectedInsureId);
		
		c.setInsured(ins);
		c.setVehicle(vehicle);
		c.setTypeContrat(tpc);
		System.out.println("contract.setInsured(ins);");
	
		int x =policeService.addPolice(c);
		System.out.println("fin");
		return "/pages/policeManagement/listContract?faces-redirect=true";
		
	}
	
	public void cancelContract(){
		RequestContext context = RequestContext.getCurrentInstance();
		 FacesMessage msg = null;
		System.out.println("******************* cancelContract");
		System.out.println("******************* id"+contract.getNumPolice());
		System.out.println(state);
		this.state= false;
		policeService.updateContract(new Police(police.getNumPolice(), state));
	}
	
	public void modifierState(Police c){
		this.police=c;
		this.id = c.getNumPolice();
		this.state= false;
		System.out.println("*******************modifierState:: police "+police);
		System.out.println("*******************modifierState:: id "+id);
		System.out.println("*******************modifierState:: state "+state);
	}
	
	@PostConstruct	
	public void init() {
		System.out.println("ggggg");
		
		contract = new Police();
		startDate = new Date();
		endDate = new Date();
		listInsured = policeService.getAllInsured();
		listVehicle = policeService.getAllVehicle();
		listContract = policeService.getAllContract(); 
       }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Insured> getAllInsured(String query) {

		List<Insured> list = policeService.getAllInsured();

		return list;
	}
	
	
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		List<Vehicle> list = policeService.getAllVehicle();
		return list;
	}

	public List<TypeContract> getAllTypeContract() {
		// TODO Auto-generated method stub
		List<TypeContract> list = policeService.getAllTypeContract();
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

	public Vehicle getSelectedVehicle() {
		return vehicle;
	}

	public void setSelectedVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public TypeContract getSelectedTypeContrat() {
		return typeContrat;
	}

	public void setSelectedTypeContrat(TypeContract typeContrat) {
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
	
	public List<Vehicle> getListVehicle() {
		listVehicle = policeService.getAllVehicle();
		return listVehicle;
	}


	public void setListVehicle(List<Vehicle> listVehicle) {
		this.listVehicle = listVehicle;
	}


	public List<TypeContract> getListTypeContract() {
		listTypeContract = policeService.getAllTypeContract();
		return listTypeContract;
	}


	public void setListTypeContract(List<TypeContract> listTypeContract) {
		this.listTypeContract = listTypeContract;
	}


	public List<Insured> getListInsured() {
		listInsured = policeService.getAllInsured();
		return listInsured;
	}

	public List<Police> getListContract() {
		listContract = policeService.getAllContract();
		return listContract;
	}


	public void setListContract(List<Police> listContract) {
		this.listContract = listContract;
	}


	public void setListInsured(List<Insured> listInsured) {
		this.listInsured = listInsured;
	}




	public Police getContract() {
		return contract;
	}




	public void setContract(Police contract) {
		this.contract = contract;
	}
	
	
	
	public Integer getSelectedInsureId() {
		return selectedInsureId;
	}




	public void setSelectedInsureId(Integer selectedInsureId) {
		this.selectedInsureId = selectedInsureId;
	}


	public int getSelectedVehicleId() {
		return selectedVehicleId;
	}


	public void setSelectedVehicleId(int selectedVehicleId) {
		this.selectedVehicleId = selectedVehicleId;
	}


	public int getSelectedTypeContactId() {
		return selectedTypeContactId;
	}


	public void setSelectedTypeContactId(int selectedTypeContactId) {
		this.selectedTypeContactId = selectedTypeContactId;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Police getPolice() {
		return police;
	}

	public void setPolice(Police police) {
		this.police = police;
	}
	
	

}
