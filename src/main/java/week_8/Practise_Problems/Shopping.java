import java.util.ArrayList;
class Customer {
    String name;
    Customer(String name) {
        this.name = name;
    }
}
class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
class Order {
    String name;
    Customer customer;
    ArrayList<Product> products = new ArrayList<>();
    String status = "Pending";
    Order(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }
    void addProduct(Product p) {
        products.add(p);
    }
    double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
    boolean isEmpty() {
        return products.isEmpty();
    }
}
interface PaymentMethod {
    boolean processPayment(double amount);
}
class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card payment: $" + amount);
        return true;
    }
}
class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
        return false;
    }
}
class BankTransferPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing Bank Transfer payment: $" + amount);
        return true;
    }
}
class PaymentProcessor {
    void pay(Order order, PaymentMethod method) {
        if (order.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }
        System.out.println("Payment initiated for Order " + order.name);
        if (method.processPayment(order.getTotal())) {
            order.status = "Paid";
            System.out.println("Payment for Order " + order.name + " successful.");
        } else {
            System.out.println("Payment for Order " + order.name + " failed.");
        }
        System.out.println("Order status: " + order.status);
    }
}
public class Shopping {
    public static void main(String[] args) {
        Customer c1 = new Customer("Customer X");
        Customer c2 = new Customer("Customer Y");
        Customer c3 = new Customer("Customer Z");
        Product p1 = new Product("Product A", 500);
        Product p2 = new Product("Product B", 300);
        Product p3 = new Product("Product C", 700);
        Order o1 = new Order("X", c1);
        o1.addProduct(p1);
        o1.addProduct(p1);
        o1.addProduct(p2);
        Order o2 = new Order("Y", c2);
        Order o3 = new Order("Z", c3);
        o3.addProduct(p3);
        PaymentProcessor processor = new PaymentProcessor();
        processor.pay(o1, new CreditCardPayment());
        System.out.println();
        processor.pay(o2, new CreditCardPayment());
        System.out.println();
        processor.pay(o3, new PayPalPayment());
    }
}
