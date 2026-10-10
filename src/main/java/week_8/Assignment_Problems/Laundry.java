abstract class WashType {
    abstract int getDuration();
    abstract double getCharge();
}
class QuickWash extends WashType {
    int getDuration() {
        return 30;
    }
    double getCharge() {
        return 20;
    }
}
class NormalWash extends WashType {
    int getDuration() {
        return 45;
    }
    double getCharge() {
        return 30;
    }
}
class HeavyWash extends WashType {
    int getDuration() {
        return 60;
    }
    double getCharge() {
        return 45;
    }
}
class Student {
    String name;
    Student(String name) {
        this.name = name;
    }
}
class WashingMachine {
    String name;
    private boolean busy = false;
    WashingMachine(String name) {
        this.name = name;
    }
    boolean isBusy() {
        return busy;
    }
    void startWash(Student student, WashType wash) {
        if (busy) {
            System.out.println("Machine " + name + " is currently busy.");
            return;
        }
        busy = true;
        System.out.println(wash.getClass().getSimpleName().replace("Wash", "")
                + " wash started on " + name + " for " + student.name
                + " (" + wash.getDuration() + " min).");

        System.out.printf("Charge: ₹%.2f%n", wash.getCharge());
    }
    void completeWash() {
        if (busy) {
            busy = false;
            System.out.println(name + " cycle completed.");
            System.out.println(name + " is now free.");
        } else {
            System.out.println(name + " is already free.");
        }
    }
}
public class Laundry {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");
        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeWash();
        m1.startWash(neha, new NormalWash());
    }
}
