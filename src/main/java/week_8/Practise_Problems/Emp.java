abstract class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
    abstract boolean checkLeave(int days);
}
class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }
    boolean checkLeave(int days) {
        return days <= 20;
    }
}
class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }
    boolean checkLeave(int days) {
        return days <= 10;
    }
}
class LeaveRequest {
    Employee employee;
    String dates;
    int days;
    private String status = "Pending";
    LeaveRequest(Employee employee, String dates, int days) {
        this.employee = employee;
        this.dates = dates;
        this.days = days;
    }
    void submit() {
        if (employee.checkLeave(days)) {
            System.out.println("Leave request submitted for " + employee.name + " (" + dates + ").");
            System.out.println("Status: " + status);
        } else {
            System.out.println("Leave request exceeds the allowed limit.");
        }
    }
    void review(String decision, String manager) {
        if (!status.equals("Pending")) {
            System.out.println("Request has already been reviewed.");
            return;
        }
        if (decision.equals("Approved") || decision.equals("Rejected")) {
            status = decision;
            System.out.println(employee.name + "'s leave request (" + dates + ") "
                    + status.toLowerCase() + " by " + manager + ".");
            System.out.println("Status: " + status);
        }
    }
    void changeStatus(String newStatus) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from "
                    + status + " to " + newStatus + ".");
        } else {
            status = newStatus;
        }
    }
}
public class Emp {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("John");
        Employee e2 = new PartTimeEmployee("Jane");

        LeaveRequest r1 = new LeaveRequest(e1, "Jan 1-5", 5);
        r1.submit();
        r1.review("Approved", "Alice");

        System.out.println();

        LeaveRequest r2 = new LeaveRequest(e2, "Feb 10-11", 2);
        r2.submit();
        r2.review("Rejected", "Bob");

        System.out.println();

        r1.changeStatus("Pending");
    }
}
