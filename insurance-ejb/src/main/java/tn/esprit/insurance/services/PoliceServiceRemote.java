package tn.esprit.insurance.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.persistence.Police;
import tn.esprit.insurance.persistence.TypeContract;

@Remote
public interface PoliceServiceRemote {
	public int addPolice(Police police);
	public int addTypeContract(TypeContract typeContract);
	public void updatePoliceById(int policeId);
	public void updateTypeContractById(int typeContractId);
	public void deleteContract(int contractId);
	public void deleteTypeContract(int typeContractId);
	public void affectContractToInsured(int contractId,int insureId);
	public void affectTypeContractToContract(int typeContractId,int contractId);
	public Police getContractById(int contractId);
	public TypeContract getTypeContractById(int typeContractId);
	public List<Police> getAllContract();
	public List<TypeContract> getAllTypeContract();
	public List<Insured> getAllInsured();
	

}
