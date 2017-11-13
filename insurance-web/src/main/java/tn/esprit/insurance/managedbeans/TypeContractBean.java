package tn.esprit.insurance.managedbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.insurance.persistence.Police;
import tn.esprit.insurance.persistence.TypeContract;
import tn.esprit.insurance.services.PoliceServiceBean;

@ManagedBean(name="typeContractBean", eager = true)
@SessionScoped
public class TypeContractBean {
	
	private String name;
	private String description;
	private float pricePerSemester;
	private float pricePerYear;
	private TypeContract selectedTypeContract;
	private TypeContract typeContract;
	private List<TypeContract> listTypeContract;
	int id;
	
	@EJB
	PoliceServiceBean policeService;
	
	public String addTypeContract(){
		System.out.println("-------------- addTypeContract");
		int x =policeService.addTypeContract(typeContract);
		this.typeContract = new TypeContract(); 
		System.out.println("-------------- TypeContract");
		this.typeContract.setName("");
		this.typeContract.setDescription("");
		this.typeContract.setPricePerSemester(0);
		this.typeContract.setPricePerYear(0);
		return "/pages/admin/gestionEmploye?faces-redirect=true";
	}
	public void deleteTypeContract(){
		System.out.println("********* deleteTypeContract");
		System.out.println("********* deleteTypeContract :: id :: "+id);
		
		policeService.deleteTypeContract(typeContract.getIdTypeContrat());
		
	}
	
	public void modifier(){
		System.out.println("********* modifier:: selectedTypeContract"+typeContract.getName());
		
	}
	
	public void initAddTypeContract(){
		selectedTypeContract = new TypeContract();

			System.out.println("-------------- initAddTypeContract");
		this.typeContract = new TypeContract(); 
		System.out.println("-------------- TypeContract");
		this.typeContract.setName("");
		this.typeContract.setDescription("");
		this.typeContract.setPricePerSemester(0);
		this.typeContract.setPricePerYear(0);
	
		
	}
	public void recupererModifId(TypeContract typeContrat){
		System.out.println("********* recupererId :: "+typeContrat.getIdTypeContrat());
		this.name = "";
		this.description = "";
		this.pricePerSemester = 0;
		this.pricePerYear = 0;
		selectedTypeContract = null;
		id= typeContrat.getIdTypeContrat();
		selectedTypeContract = policeService.getTypeContractById(id);
		System.out.println("********* selectedTypeContract id :: "+selectedTypeContract.getName());
		this.name = selectedTypeContract.getName();
		this.description = selectedTypeContract.getDescription();
		this.pricePerSemester = selectedTypeContract.getPricePerSemester();
		this.pricePerYear = selectedTypeContract.getPricePerYear();
		System.out.println("********* selectedTypeContract name :: "+name);
	}
	
	public void recupererId(TypeContract typeContrat){
		System.out.println("********* recupererId");
		id= typeContrat.getIdTypeContrat();
		System.out.println("********* recupererId :: id :: "+id);
		policeService.deleteTypeContract(id);
	}
	
	@PostConstruct	
	public void init() {
		System.out.println("ggggg");
		
		this.typeContract = new TypeContract(); 
		listTypeContract = policeService.getAllTypeContract(); 
       }

	public TypeContractBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPricePerSemester() {
		return pricePerSemester;
	}

	public void setPricePerSemester(float pricePerSemester) {
		this.pricePerSemester = pricePerSemester;
	}

	public float getPricePerYear() {
		return pricePerYear;
	}

	public void setPricePerYear(float pricePerYear) {
		this.pricePerYear = pricePerYear;
	}

	public TypeContract getTypeContract() {
		return typeContract;
	}

	public void setTypeContract(TypeContract typeContract) {
		this.typeContract = typeContract;
	}

	public List<TypeContract> getListTypeContract() {
		listTypeContract = policeService.getAllTypeContract();
		return listTypeContract;
	}

	public void setListTypeContract(List<TypeContract> listTypeContract) {
		this.listTypeContract = listTypeContract;
	}
	public TypeContract getSelectedTypeContract() {
		return selectedTypeContract;
	}
	public void setSelectedTypeContract(TypeContract selectedTypeContract) {
		this.selectedTypeContract = selectedTypeContract;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
