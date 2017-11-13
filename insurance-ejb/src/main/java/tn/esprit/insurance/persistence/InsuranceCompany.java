package tn.esprit.insurance.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class InsuranceCompany implements Serializable{

@Id
private int id ; 
private int reference; 
private String nom ; 
private String motDepasse ;
private String login ; 
private String  mail ; 
private int numero ; 
private int codeEmail ; 
private String image ; 
private String description ;
private String slogan ;
private String adresse ; 
private String ville ; 
private int codepostal ; 
private String pays ;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getReference() {
	return reference;
}
public void setReference(int reference) {
	this.reference = reference;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getMotDepasse() {
	return motDepasse;
}
public void setMotDepasse(String motDepasse) {
	this.motDepasse = motDepasse;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public int getCodeEmail() {
	return codeEmail;
}
public void setCodeEmail(int codeEmail) {
	this.codeEmail = codeEmail;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getSlogan() {
	return slogan;
}
public void setSlogan(String slogan) {
	this.slogan = slogan;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public int getCodepostal() {
	return codepostal;
}
public void setCodepostal(int codepostal) {
	this.codepostal = codepostal;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	InsuranceCompany other = (InsuranceCompany) obj;
	if (id != other.id)
		return false;
	return true;
} 





}

