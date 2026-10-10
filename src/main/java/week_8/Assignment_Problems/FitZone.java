abstract class MembershipPlan {
    double basePrice = 1000;

    abstract double calculatePrice();
}
class MonthlyPlan extends MembershipPlan {
    double calculatePrice() {
        return basePrice;
    }
}
class QuarterlyPlan extends MembershipPlan {
    double calculatePrice() {
        return basePrice * 3 * 0.90;
    }
}
class AnnualPlan extends MembershipPlan {
    double calculatePrice() {
        return basePrice * 12 * 0.75;
    }
}
class Member {
    String name;
    MembershipPlan plan;
    String status;
    Member(String name, MembershipPlan plan) {
        this.name = name;
        this.plan = plan;
        status = "Active";
    }
    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(name + " checked in successfully.");
        } else {
            System.out.println(name + " cannot check in. Status: " + status);
        }
    }
    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(name + "'s membership is frozen.");
        } else {
            System.out.println(name + " cannot freeze membership. Status: " + status);
        }
    }
    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(name + "'s membership is active again.");
        } else {
            System.out.println(name + " cannot unfreeze membership. Status: " + status);
        }
    }
    void expire() {
        status = "Expired";
        System.out.println(name + "'s membership has expired.");
    }
    void displayPrice() {
        System.out.printf("%s's membership fee: ₹%.2f%n",
                name, plan.calculatePrice());
    }
}
public class FitZone {
    public static void main(String[] args) {
        Member asha = new Member("Asha", new QuarterlyPlan());
        Member ravi = new Member("Ravi", new MonthlyPlan());
        asha.displayPrice();
        ravi.displayPrice();
        asha.checkIn();
        asha.freeze();
        asha.checkIn();
        ravi.expire();
        ravi.freeze();
        ravi.checkIn();
    }
}