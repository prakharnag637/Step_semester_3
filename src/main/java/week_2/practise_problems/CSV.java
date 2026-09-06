
class StudentRecord {
    void parseStudentRecord(String csvLine) {
        String[] data = csvLine.split(",");
        if (data.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + data[0] +
                           " | Roll No: " + data[1] +
                           " | Dept: " + data[2]);
    }
}
public class CSV {
    public static void main(String[] args) {
        StudentRecord obj = new StudentRecord();
        obj.parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
    }
}