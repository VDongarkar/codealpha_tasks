
import java.util.*;

class HotelReservationSystem {
    static class Room {
        int id;
        String type;
        double price;
        boolean available = true;

        Room(int id, String type, double price) {
            this.id = id;
            this.type = type;
            this.price = price;
        }
    }

    static class Reservation {
        int roomId;
        String guest, checkIn, checkOut, payment = "Pending";

        Reservation(int roomId, String guest, String checkIn, String checkOut) {
            this.roomId = roomId;
            this.guest = guest;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
    }

    List<Room> rooms = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();

    void addRoom(int id, String type, double price) {
        rooms.add(new Room(id, type, price));
    }

    List<Room> searchRooms(String type) {
        List<Room> available = new ArrayList<>();
        for (Room r : rooms)
            if (r.available && (type == null || r.type.equalsIgnoreCase(type)))
                available.add(r);
        return available;
    }

    String reserveRoom(int id, String guest, String in, String out) {
        for (Room r : rooms)
            if (r.id == id && r.available) {
                r.available = false;
                reservations.add(new Reservation(id, guest, in, out));
                return "Reserved Room " + id;
            }
        return "Room unavailable";
    }

    String processPayment(int id) {
        for (Reservation r : reservations)
            if (r.roomId == id)
                return (r.payment = "Completed");
        return "Reservation not found";
    }

    void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        boolean found = false;
        for (Room r : rooms) {
            if (r.available) {
                System.out.println("Room ID: " + r.id + ", Type: " + r.type + ", Price: Rs." + r.price);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms are available at the moment.");
        }
    }

    void selectRoom(Scanner scanner) {
        displayAvailableRooms(); // Show available rooms
        if (rooms.stream().noneMatch(r -> r.available)) {
            System.out.println("No rooms available for selection.");
            return;
        }

        System.out.print("\nEnter the Room ID you want to reserve: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Guest Name: ");
        String guest = scanner.nextLine();

        System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
        String checkIn = scanner.nextLine();

        System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
        String checkOut = scanner.nextLine();

        String result = reserveRoom(roomId, guest, checkIn, checkOut);
        System.out.println(result);
    }
}

public class HotelRS {
    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();

        Scanner scanner = new Scanner(System.in);

        hotel.addRoom(101, "Single", 100);
        hotel.addRoom(102, "Double", 150);
        hotel.addRoom(103, "Suite", 250);

        hotel.displayAvailableRooms();

        hotel.selectRoom(scanner);

        scanner.close();
    }
}
