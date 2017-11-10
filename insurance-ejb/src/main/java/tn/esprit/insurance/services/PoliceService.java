package tn.esprit.insurance.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.persistence.Police;
import tn.esprit.insurance.persistence.TypeContract;

@Stateless
public class PoliceService implements PoliceServiceRemote{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int addPolice(Police police) {
		// TODO Auto-generated method stub
		em.persist(police);
		return police.getNumPolice();
	}

	@Override
	public int addTypeContract(TypeContract typeContract) {
		// TODO Auto-generated method stub
		em.persist(typeContract);
		return typeContract.getIdTypeContrat();
	}

	@Override
	public void updatePoliceById(int policeId) {
		// TODO Auto-generated method stub
		Police police = em.find(Police.class, policeId);
		
		
	}

	@Override
	public void updateTypeContractById(int typeContractId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContract(int contractId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTypeContract(int typeContractId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affectContractToInsured(int contractId, int insureId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affectTypeContractToContract(int typeContractId, int contractId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Police getContractById(int contractId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeContract getTypeContractById(int typeContractId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Police> getAllContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeContract> getAllTypeContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Insured> getAllInsured() {
		// TODO Auto-generated method stub
		TypedQuery<Insured> query = em.createQuery("Select e from Insured e", Insured.class);
		List<Insured> listInsured = null;
		try{
			listInsured = query.getResultList();
		}catch(NoResultException e){
			//Logger.info("Aucun employe trouvé pour cet email: "+email);
		}
		return listInsured;
	}

}
