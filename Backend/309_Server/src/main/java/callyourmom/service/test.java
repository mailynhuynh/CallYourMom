package callyourmom.service;


import callyourmom.user.Reminder;
import callyourmom.*;

public class test {
	
	public static void main(String[] args) {
		ReminderService r = new ReminderService();
		Reminder A = new Reminder();
		Reminder B = new Reminder();
		
		A.setTime(" 4/28/2019 15:0 ");
		B.setTime(" 4/29/2019 16:0 ");
		
		Reminder mostRecent = r.testgetMostRecent(A, B);
		System.out.println(mostRecent.getTime());
		
		
		
		
		
		
	}

}
