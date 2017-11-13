package tn.esprit.insurance.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.persistence.Police;
import tn.esprit.insurance.persistence.TypeContract;
import tn.esprit.insurance.persistence.Vehicle;

@Remote
public interface PoliceServiceRemote {
	public int addPolice(Police police);
	public int addTypeContract(TypeContract typeContract);
	public int addInsured(Insured insured);
	public int addVehicle(Vehicle vehicle);
	public void updatePoliceById(int policeId);
	public void updateTypeContractById(int typeContractId);
	public void updateContract(Police ContracId);
	public void cancelContract(int contractId);
	public void deleteTypeContract(int typeContractId);
	public void affectContractToInsured(int contractId,int insureId);
	public void affectTypeContractToContract(int typeContractId,int contractId);
	public Police getContractById(int contractId);
	public List<Police> getContractByDate(Date date);
	public Insured getInsuredById(int insuredId);
	public Vehicle getVehicleById(int vehicleId);
	public TypeContract getTypeContractById(int typeContractId);
	public List<Police> getAllContract();
	public List<TypeContract> getAllTypeContract();
	public List<Insured> getAllInsured();
	public List<Vehicle> getAllVehicle();  
	public void sendMail(String email,String name, String date);
	
	

}
