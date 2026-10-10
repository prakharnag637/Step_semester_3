import java.util.*;
abstract class Staff {
    String name;
    String type;
    Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }
    abstract int calculatePay();
    @Override
    public String toString() {
        return "Payslip[name=" + name + ", type=" + type
                + ", pay=" + calculatePay() + "]";
    }
}
class FullTime extends Staff {
    int salary;
    FullTime(String name, int salary) {
        super(name, "FullTime");
        this.salary = salary;
    }
    @Override
    int calculatePay() {
        return salary;
    }
}
class PartTime extends Staff {
    int hours, rate;
    PartTime(String name, int hours, int rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }
    @Override
    int calculatePay() {
        return hours * rate;
    }
}
class Intern extends Staff {
    int stipend;
    Intern(String name, int stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }
    @Override
    int calculatePay() {
        return stipend;
    }
}
public class Payroll{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Staff[] staff = new Staff[100];
        int n = 0;
        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "FullTime":
                    staff[n++] = new FullTime(name, sc.nextInt());
                    break;
                case "PartTime":
                    staff[n++] = new PartTime(
                            name, sc.nextInt(), sc.nextInt());
                    break;
                case "Intern":
                    staff[n++] = new Intern(name, sc.nextInt());
                    break;
            }
        }
        int total = 0;
        int topper = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(staff[i]);
            total += staff[i].calculatePay();
            if (staff[i].calculatePay() >
                    staff[topper].calculatePay()) {
                topper = i;
            }
        }
        System.out.println("Total " + total);
        if (n > 0) {
            System.out.println("top earner " + staff[topper].name);
        }
        sc.close();
    }
}