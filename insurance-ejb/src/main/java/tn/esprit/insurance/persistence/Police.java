package tn.esprit.insurance.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Police implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numPolice;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private float price;
	private int classe;
	private boolean state;
	
	@OneToOne
	private Insured insured;
	
	@OneToOne
	private Vehicle vehicle;
	
	@ManyToOne
	private TypeContract typeContrat;

	public Police() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Police(int numPolice, boolean state) {
		super();
		this.numPolice = numPolice;
		this.state = state;
	}


	public Police(Date startDate, Date endDate, Date dateCreation, float price, int classe) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.classe = classe;
		this.state = true;
	}

	public int getNumPolice() {
		return numPolice;
	}

	public void setNumPolice(int numPolice) {
		this.numPolice = numPolice;
	}

	public Date getstartDate() {
		return startDate;
	}

	public void setstartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getendDate() {
		return endDate;
	}

	public void setendDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getclasse() {
		return classe;
	}

	public void setclasse(int classe) {
		this.classe = classe;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	

}
