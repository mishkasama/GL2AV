package tn.esprit.insurance.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Police implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numPolice;
	
	private Date startDate;
	private Date endDate;
	private float price;
	private int points;
	
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

	public Police(Date startDate, Date endDate, float price, int points) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.points = points;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
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
	
	

}
