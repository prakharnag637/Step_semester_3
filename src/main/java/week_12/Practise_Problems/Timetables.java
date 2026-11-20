
import java.util.*;

class Timetable {

    String sectionName;
    List<String> periods;

    // Constructor
    Timetable(String sectionName, List<String> periods) {
        this.sectionName = sectionName;
        this.periods = periods;
    }

    // Deep copy method
    Timetable copy() {

        List<String> newPeriods = new ArrayList<>(periods);

        return new Timetable(sectionName, newPeriods);
    }

    // Change a period
    void setPeriod(int period, String subject) {

        if (period < 1 || period > periods.size()) {
            System.out.println("Invalid period");
            return;
        }

        periods.set(period - 1, subject);
    }

    // Display timetable
    void display() {

        System.out.println(sectionName + ": " + periods);
    }
}

public class Timetables {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String originalName = sc.next();

        int n = sc.nextInt();

        List<String> subjects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            subjects.add(sc.next());
        }

        Timetable original = new Timetable(originalName, subjects);

        Timetable copied = original.copy();

        copied.sectionName = sc.next();

        int period = sc.nextInt();
        String subject = sc.next();

        copied.setPeriod(period, subject);

        original.display();
        copied.display();

        sc.close();
    }
}
