class FeeAccount {
}
class HostelFeeAccount extends FeeAccount {
}
class PaymentSystem {
    int hostelCount = 0;
    int dayCount = 0;
    void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println(
                "Paid in two installments (hostel account)"
            );
            hostelCount++;
        } else {
            System.out.println(
                "Paid in one go (day-scholar account)"
            );
            dayCount++;
        }
    }
    void display() {
        System.out.println(
            "Hostel accounts processed: " + hostelCount
            + " | Day-scholar accounts processed: " + dayCount
        );
    }
}
public class Account {
    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };
        PaymentSystem p = new PaymentSystem();
        for (FeeAccount account : accounts) {
            p.processPayment(account, 60000);
        }
        p.display();
    }
}