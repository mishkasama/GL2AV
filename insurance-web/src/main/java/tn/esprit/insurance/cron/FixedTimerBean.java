package tn.esprit.insurance.cron;

import java.text.ParseException;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class FixedTimerBean {
 
    @EJB
    private WorkerBean workerBean;
 
    @Lock(LockType.READ)
    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
//    @Schedule(dayOfWeek="Mon-Fri", minute = "*") 
    public void atSchedule() throws InterruptedException, ParseException {
        //workerBean.doTimerWork();
    }
}
