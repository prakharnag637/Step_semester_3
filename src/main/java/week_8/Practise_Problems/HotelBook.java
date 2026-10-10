import java.time.LocalDate;
import java.util.ArrayList;
abstract class Room {
    int roomNumber;
    double rate;
    Room(int roomNumber, double rate) {
        this.roomNumber = roomNumber;
        this.rate = rate;
    }
    abstract double calculatePrice(int days);
}
class StandardRoom extends Room {
    StandardRoom(int roomNumber, double rate) {
        super(roomNumber, rate);
    }
    double calculatePrice(int days) {
        return rate * days;
    }
}
class DeluxeRoom extends Room {
    DeluxeRoom(int roomNumber, double rate) {
        super(roomNumber, rate);
    }
    double calculatePrice(int days) {
        return rate * days + 500;
    }
}
class Customer {
    String name;
    Customer(String name) {
        this.name = name;
    }
}
class Reservation {
    Room room;
    Customer customer;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate cancellationDeadline;
    boolean active = true;
    Reservation(Room room, Customer customer, LocalDate startDate,
                LocalDate endDate, LocalDate cancellationDeadline) {
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationDeadline = cancellationDeadline;
    }
    boolean overlaps(LocalDate start, LocalDate end) {
        return start.isBefore(endDate) && end.isAfter(startDate);
    }
    void cancel() {
        if (!active) {
            System.out.println("Reservation is already cancelled.");
        } else if (LocalDate.now().isAfter(cancellationDeadline)) {
            System.out.println("Cancellation deadline has passed.");
        } else {
            active = false;
            System.out.println("Reservation for " + customer.name + ", Room "
                    + room.roomNumber + " cancelled successfully.");
        }
    }
}
class Hotel {
    ArrayList<Reservation> reservations = new ArrayList<>();
    boolean isAvailable(Room room, LocalDate start, LocalDate end) {
        for (Reservation r : reservations) {
            if (r.room == room && r.active && r.overlaps(start, end)) {
                return false;
            }
        }
        return true;
    }
    void bookRoom(Room room, Customer customer, LocalDate start,
                  LocalDate end, LocalDate deadline) {
        if (!start.isBefore(end)) {
            System.out.println("Invalid booking dates.");
            return;
        }
        if (isAvailable(room, start, end)) {
            Reservation r = new Reservation(room, customer, start, end, deadline);
            reservations.add(r);
            long days = java.time.temporal.ChronoUnit.DAYS.between(start, end);
            System.out.println("Reservation confirmed for " + customer.name
                    + ", Room " + room.roomNumber + " (" + start + " to " + end + ")");
            System.out.println("Price: $" + room.calculatePrice((int) days));
        } else {
            System.out.println("Room " + room.roomNumber
                    + " is not available for the selected dates.");
        }
    }
}
public class HotelBook {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Room standard = new StandardRoom(101, 1000);
        Room deluxe = new DeluxeRoom(201, 2000);
        Customer c1 = new Customer("Customer A");
        Customer c2 = new Customer("Customer B");
        Customer c3 = new Customer("Customer C");
        LocalDate start1 = LocalDate.of(2026, 11, 1);
        LocalDate end1 = LocalDate.of(2026, 11, 5);
        LocalDate deadline = LocalDate.of(2026, 10, 25);
        System.out.println("Checking room availability...");
        if (hotel.isAvailable(standard, start1, end1)) {
            System.out.println("Standard Room 101 is available.");
        }
        hotel.bookRoom(standard, c1, start1, end1, deadline);
        hotel.bookRoom(standard, c2,
                LocalDate.of(2026, 11, 3),
                LocalDate.of(2026, 11, 7),
                LocalDate.of(2026, 10, 27));
        hotel.reservations.get(0).cancel();
        hotel.bookRoom(deluxe, c3,
                LocalDate.of(2026, 12, 10),
                LocalDate.of(2026, 12, 12),
                LocalDate.of(2026, 12, 1));
    }
}
