import java.util.*;
class Show {
    String showName;
    HashMap<String, Double> bookedSeats = new HashMap<>();
    Show(String showName) {
        this.showName = showName;
    }
    double getPrice(String category) {
        if (category.equalsIgnoreCase("Regular")) {
            return 150;
        } else if (category.equalsIgnoreCase("Premium")) {
            return 250;
        } else if (category.equalsIgnoreCase("Recliner")) {
            return 400;
        }
        return 0;
    }
    void bookTickets(String customer, String[] seats, String category) {
        if (seats.length > 6) {
            System.out.println("Maximum 6 seats allowed per booking.");
            return;
        }
        for (String seat : seats) {
            if (bookedSeats.containsKey(seat)) {
                System.out.println("Seat " + seat + " is already booked.");
                return;
            }
        }
        double price = getPrice(category);
        if (price == 0) {
            System.out.println("Invalid seat category.");
            return;
        }
        double total = price * seats.length;
        for (String seat : seats) {
            bookedSeats.put(seat, price);
        }
        System.out.println(customer + " booked " + seats.length
                + " " + category + " seat(s).");
        System.out.printf("Total amount: ₹%.2f%n", total);
    }
    void cancelBooking(String customer, String[] seats, boolean showStarted) {
        if (showStarted) {
            System.out.println("Cannot cancel after the show starts.");
            return;
        }
        for (String seat : seats) {
            if (!bookedSeats.containsKey(seat)) {
                System.out.println("Seat " + seat + " is not booked.");
                return;
            }
        }
        for (String seat : seats) {
            bookedSeats.remove(seat);
        }
        System.out.println(customer + "'s booking cancelled successfully.");
    }
}
public class Campus {
    public static void main(String[] args) {
        Show show = new Show("Campus Premiere");
        show.bookTickets("Asha", new String[]{"A1", "A2"}, "Regular");
        show.bookTickets("Ravi", new String[]{"B1", "B2"}, "Premium");
        show.bookTickets("Neha", new String[]{"A1"}, "Recliner");
        show.cancelBooking("Asha", new String[]{"A1", "A2"}, false);
        show.bookTickets("Neha", new String[]{"A1"}, "Recliner");
        show.cancelBooking("Ravi", new String[]{"B1", "B2"}, true);
    }
}