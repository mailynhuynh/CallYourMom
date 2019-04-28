package callyourmom.service;

public class test {
	
	public static void main(String [] args) {
		ReminderService r = new ReminderService();
		System.out.println(r.getMostRecent().getTime());
	}

}
