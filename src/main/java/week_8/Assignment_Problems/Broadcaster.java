import java.util.*;
interface NotificationChannel {
    void send(String studentName, String noticeTitle);
}
class EmailChannel implements NotificationChannel {
    public void send(String studentName, String noticeTitle) {
        System.out.println("Email sent to " + studentName + ": " + noticeTitle);
    }
}
class SMSChannel implements NotificationChannel {
    public void send(String studentName, String noticeTitle) {
        System.out.println("SMS sent to " + studentName + ": " + noticeTitle);
    }
}
class AppChannel implements NotificationChannel {
    public void send(String studentName, String noticeTitle) {
        System.out.println("App notification sent to " + studentName + ": " + noticeTitle);
    }
}
class Student {
    String name;
    String department;
    ArrayList<NotificationChannel> channels = new ArrayList<>();
    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }
    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}
class Notice {
    String title;
    ArrayList<String> departments;
    Notice(String title, ArrayList<String> departments) {
        this.title = title;
        this.departments = departments;
    }
}
class NoticeBroadcaster {
    void postNotice(Notice notice, ArrayList<Student> students) {
        if (notice.departments == null || notice.departments.isEmpty()) {
            System.out.println("Notice rejected: No target department specified.");
            return;
        }
        System.out.println("Notice posted: " + notice.title);
        for (Student student : students) {
            if (notice.departments.contains(student.department)) {
                for (NotificationChannel channel : student.channels) {
                    channel.send(student.name, notice.title);
                }
            }
        }
    }
}
public class Broadcaster {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student asha = new Student("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());
        Student ravi = new Student("Ravi", "ECE");
        ravi.addChannel(new SMSChannel());
        students.add(asha);
        students.add(ravi);
        NoticeBroadcaster broadcaster = new NoticeBroadcaster();
        ArrayList<String> departments1 = new ArrayList<>();
        departments1.add("CSE");
        Notice notice1 = new Notice("Hackathon Registration", departments1);
        broadcaster.postNotice(notice1, students);
        System.out.println();
        ArrayList<String> departments2 = new ArrayList<>();
        departments2.add("CSE");
        departments2.add("ECE");
        Notice notice2 = new Notice("Exam Schedule", departments2);
        broadcaster.postNotice(notice2, students);
        System.out.println();
        ArrayList<String> departments3 = new ArrayList<>();
        Notice notice3 = new Notice("General Notice", departments3);
        broadcaster.postNotice(notice3, students);
    }
}