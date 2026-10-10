import java.util.*;
interface Chargeable {
    void charge();
}
class Vehicle {
    String passNumber;
    String owner;
    String type;
    int fee;
    Vehicle(String passNumber, String owner, String type, int fee) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;
        this.fee = fee;
    }
    void display() {
        System.out.println(passNumber + " (" + type + ") pass fee " + fee);
    }
    void charge() {
        System.out.println(passNumber + " rejected: charging unsupported");
    }
}
class Bike extends Vehicle {
    Bike(String passNumber, String owner) {
        super(passNumber, owner, "Bike", 300);
    }
}
class Car extends Vehicle {
    Car(String passNumber, String owner) {
        super(passNumber, owner, "Car", 1000);
    }
}
class EBike extends Vehicle implements Chargeable {
    EBike(String passNumber, String owner) {
        super(passNumber, owner, "EBike", 300);
    }
    @Override
    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}
class ECar extends Vehicle implements Chargeable {
    ECar(String passNumber, String owner) {
        super(passNumber, owner, "ECar", 1000);
    }
    @Override
    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}
public class PassSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();
        while (sc.hasNext()) {
            String operation = sc.next();
            if (operation.equals("PASS")) {
                String type = sc.next();
                String passNumber = sc.next();
                String owner = sc.next();
                Vehicle v = null;
                switch (type) {
                    case "Bike":
                        v = new Bike(passNumber, owner);
                        break;
                    case "Car":
                        v = new Car(passNumber, owner);
                        break;
                    case "EBike":
                        v = new EBike(passNumber, owner);
                        break;
                    case "ECar":
                        v = new ECar(passNumber, owner);
                        break;
                }
                if (v != null) {
                    vehicles.put(passNumber, v);
                    v.display();
                }
            } else if (operation.equals("CHARGE")) {
                String passNumber = sc.next();
                if (vehicles.containsKey(passNumber)) {
                    vehicles.get(passNumber).charge();
                } else {
                    System.out.println("Vehicle not found");
                }
            }
        }
        sc.close();
    }
}