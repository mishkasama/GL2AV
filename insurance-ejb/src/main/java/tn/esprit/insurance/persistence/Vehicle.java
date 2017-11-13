package tn.esprit.insurance.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehicle implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdVehicle;
	
	private String registration;
	private String marque;
	
	@OneToMany(mappedBy="vehicle")
	private List<Police> polices;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Vehicle(String registration, String marque) {
		super();
		this.registration = registration;
		this.marque = marque;
	}



	public int getIdVehicle() {
		return IdVehicle;
	}

	public void setIdVehicle(int idVehicle) {
		IdVehicle = idVehicle;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public List<Police> getPolices() {
		return polices;
	}

	public void setPolices(List<Police> polices) {
		this.polices = polices;
	}
	
	

}
