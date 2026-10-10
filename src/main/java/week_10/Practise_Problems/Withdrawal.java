import java.util.*;
class Account {
    String id;
    int balance;
    Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }
    void withdraw(int amount) {
        System.out.println(id + " balance " + (balance - amount));
    }
}
class Savings extends Account {
    Savings(String id, int balance) {
        super(id, balance);
    }
    @Override
    void withdraw(int amount) {
        if (balance - amount < 1000) {
            System.out.println(id + " rejected: minimum balance 1000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + balance);
        }
    }
}
class Current extends Account {
    Current(String id, int balance) {
        super(id, balance);
    }
    @Override
    void withdraw(int amount) {
        if (balance - amount < -5000) {
            System.out.println(id + " rejected: overdraft limit 5000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + balance);
        }
    }
}
public class Withdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();
        while (sc.hasNext()) {
            String operation = sc.next();
            if (operation.equals("Savings")) {
                String id = sc.next();
                int balance = sc.nextInt();
                accounts.put(id, new Savings(id, balance));
            } else if (operation.equals("Current")) {
                String id = sc.next();
                int balance = sc.nextInt();
                accounts.put(id, new Current(id, balance));
            } else if (operation.equals("WITHDRAW")) {
                String id = sc.next();
                int amount = sc.nextInt();
                if (!accounts.containsKey(id)) {
                    System.out.println("Account not found");
                } else {
                    accounts.get(id).withdraw(amount);
                }
            }
        }
        sc.close();
    }
}