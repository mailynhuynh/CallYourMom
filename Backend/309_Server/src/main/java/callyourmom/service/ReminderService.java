package callyourmom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import callyourmom.repository.ReminderRepository;
import callyourmom.user.Reminder;

@Service
public class ReminderService {

	@Autowired
	ReminderRepository reminderRepository;

	public List<Reminder> getAll() {
		return reminderRepository.findAll();
	}

	public Reminder get(Integer id) {
		return reminderRepository.getOne(id);
	}

	public Reminder create(Reminder reminder) {
		return reminderRepository.save(reminder);
	}

	public Reminder getMostRecent() {
		List<Reminder> all = reminderRepository.findAll();
		
// 		DEBUG:
//		Reminder A = new Reminder();
//		A.setTime("4/22/2019 7:00");
//		Reminder B = new Reminder();
//		B.setTime("4/22/2019 11:00");
//		Reminder C = new Reminder();
//		C.setTime("4/25/2019 9:00");
//
//		all.add(A);
//		all.add(B);
//		all.add(C);

		Reminder mostRecent = all.get(0);

		for (int i = 1; i < all.size(); i++) {

			if (earlier(all.get(i), mostRecent)) {
				mostRecent = all.get(i);
			}
		}
		return mostRecent;
	}

	public boolean earlier(Reminder A, Reminder B) {

		String timeA = A.getTime();
		String timeB = B.getTime();

		String[] datetimeA = timeA.split(" ");
		String[] datetimeB = timeB.split(" ");

		if (compareDate(datetimeA[0], datetimeB[0])) {
			return true;
		} else if (datetimeA.equals(datetimeB)) {
			return compareTime(datetimeA[1], datetimeB[1]);
		}

		return false;

	}

	private boolean compareDate(String A, String B) {
		String[] dateA = A.split("/");
		String[] dateB = B.split("/");

		if (Integer.valueOf(dateA[2]) < (Integer.valueOf(dateB[2]))) {
			return true;
		} else if (Integer.valueOf(dateA[2]).equals(Integer.valueOf(dateB[2]))) {
			if (Integer.valueOf(dateA[0]) < (Integer.valueOf(dateB[0]))) {
				return true;
			} else if (Integer.valueOf(dateA[0]).equals(Integer.valueOf(dateB[0]))) {
				if (Integer.valueOf(dateA[1]) < (Integer.valueOf(dateB[1])))
					return true;
			}
		}

		return false;
	}

	private boolean compareTime(String A, String B) {
		String[] dateA = A.split(":");
		String[] dateB = B.split(":");

		if (Integer.valueOf(dateA[0]) < (Integer.valueOf(dateB[0]))) {
			return true;
		} else if (Integer.valueOf(dateA[0]).equals(Integer.valueOf(dateB[0]))) {
			if (Integer.valueOf(dateA[1]) < (Integer.valueOf(dateB[1]))) {
				return true;
			}
		}

		return false;
	}

}
