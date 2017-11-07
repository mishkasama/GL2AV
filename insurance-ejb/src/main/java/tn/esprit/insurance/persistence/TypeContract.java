package tn.esprit.insurance.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeContract implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdTypeContrat;
	
	private String name;
	private float pricePerSemester;
	private float pricePerYear;
	public TypeContract() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeContract(String name, float pricePerSemester, float pricePerYear) {
		super();
		this.name = name;
		this.pricePerSemester = pricePerSemester;
		this.pricePerYear = pricePerYear;
	}
	public int getIdTypeContrat() {
		return IdTypeContrat;
	}
	public void setIdTypeContrat(int idTypeContrat) {
		IdTypeContrat = idTypeContrat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	

}
