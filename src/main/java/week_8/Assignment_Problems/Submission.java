class Assignment {
    String studentName;
    String assignmentName;
    String type;
    int maxMarks;
    int dueDay;
    int submittedDay;
    boolean graded = false;
    double finalMarks;
    Assignment(String studentName, String assignmentName, String type,
               int maxMarks, int dueDay, int submittedDay) {
        this.studentName = studentName;
        this.assignmentName = assignmentName;
        this.type = type;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
        this.submittedDay = submittedDay;
    }
    void submit() {
        if (graded) {
            System.out.println("Cannot resubmit after grading.");
        } else {
            System.out.println(studentName + " submitted " + assignmentName + ".");
        }
    }
    void grade(double marks) {
        if (graded) {
            System.out.println("Assignment is already graded.");
            return;
        }
        int lateDays = Math.max(0, submittedDay - dueDay);
        double penaltyRate;
        if (type.equalsIgnoreCase("Coding")) {
            penaltyRate = 0.10;
        } else {
            penaltyRate = 0.20;
        }
        double penalty = marks * penaltyRate * lateDays;
        finalMarks = Math.max(0, marks - penalty);
        graded = true;
        System.out.printf("%s's final marks: %.0f/ %d%n",
                studentName, finalMarks, maxMarks);
    }
}
public class Submission {
    public static void main(String[] args) {
        Assignment a1 = new Assignment(
                "Asha", "Linked List Lab", "Coding", 50, 10, 10);
        Assignment a2 = new Assignment(
                "Ravi", "Design Essay", "Written", 50, 12, 14);
        a1.submit();
        a2.submit();
        a1.grade(45);
        a2.grade(40);
        a1.submit();
    }
}