package tn.esprit.insurance.services;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.persistence.Police;
import tn.esprit.insurance.persistence.TypeContract;
import tn.esprit.insurance.persistence.Vehicle;

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
	public int addInsured(Insured insured) {
		// TODO Auto-generated method stub
		em.persist(insured);
		return insured.getIdInsured();
	}
	
	@Override
	public int addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		em.persist(vehicle);
		return vehicle.getIdVehicle();
	}
	
	@Override
	public int addTypeContract(TypeContract typeContract) {
		// TODO Auto-generated method stub
		em.persist(typeContract);
		return typeContract.getIdTypeContrat();
	}

	@Override
	public void updateContract(Police Contrac){
		em.merge(Contrac);
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
	public void cancelContract(int contractId) {
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

	public Police getContractById(int contractId) {
		// TODO Auto-generated method stub
		Police e = em.find(Police.class, contractId);
		
		return e;
	
	}
	
	@Override
	public Vehicle getVehicleById(int vehicleId) {
		// TODO Auto-generated method stub
		Vehicle e = em.find(Vehicle.class, vehicleId);
		
		return e;
	
	}
	
	@Override
	public Insured getInsuredById(int insuredId) {
		// TODO Auto-generated method stub
		Insured e = em.find(Insured.class, insuredId);
		
		return e;
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
		TypedQuery<TypeContract> query = em.createQuery("Select e from TypeContract e", TypeContract.class);
		List<TypeContract> listTypeContract = null;
		try{
			listTypeContract = query.getResultList();
		}catch(NoResultException e){
			//Logger.info("Aucun employe trouvé pour cet email: "+email);
		}
		return listTypeContract;
		
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

	@Override
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		TypedQuery<Vehicle> query = em.createQuery("Select e from Vehicle e", Vehicle.class);
		List<Vehicle> listVehicle = null;
		try{
			listVehicle = query.getResultList();
		}catch(NoResultException e){
			//Logger.info("Aucun employe trouvé pour cet email: "+email);
		}
		return listVehicle;
	}
	
	public List<Police> getContractByDate(Date date){
		TypedQuery<Police> query = em.createQuery("Select e from Police e where e.endDate = :date", Police.class);
		List<Police> listContract = null;
		try{
			listContract = query.setParameter("date", date).getResultList();
		}catch(NoResultException e){
			//Logger.info("Aucun employe trouvé pour cet email: "+email);
		}
		return listContract;
		
	}
	
	public void sendMail(String email,String name, String date) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("aboudimariem93@gmail.com","58323183A");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("meriem.aboudi@esprit.tn"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("meriem.aboudi@esprit.tn"));
			message.setSubject("Expiration contract");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
