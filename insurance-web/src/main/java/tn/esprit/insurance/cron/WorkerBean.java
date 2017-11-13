package tn.esprit.insurance.cron;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import tn.esprit.insurance.email.SendMailSSL;
import tn.esprit.insurance.persistence.Police;
import tn.esprit.insurance.services.PoliceServiceBean;

@Singleton
public class WorkerBean {
	
	@EJB
	PoliceServiceBean policeService;
	
    private AtomicBoolean busy = new AtomicBoolean(false);
 
    @Lock(LockType.READ)
    public void doTimerWork() throws InterruptedException, ParseException {
    	System.out.println("---------------- Cron -------------");
        if (!busy.compareAndSet(false, true)) {
        	System.out.println("---------------- Cron if -------------");
            return;
        }
        try {
        	Calendar calendar = Calendar.getInstance();
        	 
            //définir le format de la date
        	List<Police>listPolice = new ArrayList<Police>();
        	Police police = new Police();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            calendar.add(Calendar.DATE, 7);
            String date1 = sdf.format(calendar.getTime());
            Date date = sdf.parse(date1);
            listPolice = policeService.getContractByDate(date);
            System.out.println("Dans une semaine, nous serons le: "+sdf.format(calendar.getTime()));
            String name ="";
            //Afficher la date du joru
            System.out.println("Aujourd'hui, nous sommes le: "+sdf.format(calendar.getTime()));
            for(int i=1;i< listPolice.size();i++){
            	police = listPolice.get(i);
            	if(police !=null){
//            	System.out.println("Aujourd'hui, envoi mail à:"+police.getNumPolice()+" le: "+sdf.format(calendar.getTime()));
//            	name = police.getInsured().getFirstName()+" "+police.getInsured().getLastName();
//            	policeService.sendMail(" a", name, date1);
            	}
            	
            	
        		
        		
        		
            	
            	
            	
            	
            }
        	
        	System.out.println("---------------- Cron try -------------");
            Thread.sleep(20000L);
        } finally {
            busy.set(false);
        }
    }
}