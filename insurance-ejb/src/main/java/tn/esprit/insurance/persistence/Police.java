package tn.esprit.insurance.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Police implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numPolice;
	
	private Date startDebut;
	private Date endDebut;
	private float price;
	private int points;
	
	@OneToOne
	private Insured insured;
	
	@OneToOne
	private Vehicle vehicle;

}
