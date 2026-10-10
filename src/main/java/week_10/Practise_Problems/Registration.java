import java.util.*;
class Student {
    String rollNumber;
    String name;
    Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Student))
            return false;
        Student s = (Student) obj;
        return rollNumber.equals(s.rollNumber);
    }
    @Override
    public int hashCode() {
        return rollNumber.hashCode();
    }
}
public class Registration{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Student> students = new HashSet<>();
        while (sc.hasNext()) {
            String operation = sc.next();
            if (operation.equals("ADD")) {
                String roll = sc.next();
                String name = sc.next();
                Student s = new Student(roll, name);
                if (students.add(s))
                    System.out.println("Added");
                else
                    System.out.println("duplicate rejected");
            } else if (operation.equals("CONTAINS")) {
                String roll = sc.next();
                String name = sc.next();
                Student s = new Student(roll, name);
                System.out.println("contains: " + students.contains(s));
            }
        }
        System.out.println("member count " + students.size());
        sc.close();
    }
}