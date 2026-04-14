class Passenger {
    private String name;
    private int id;

    public Passenger(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

class Flight {
    private final int MAX_SEATS;
    private Passenger[] seats;

    public Flight(int maxSeats) {
        this.MAX_SEATS = maxSeats;
        this.seats = new Passenger[MAX_SEATS];
        System.out.println("Flight Created with " + MAX_SEATS + " seats.\n");
    }

    public boolean bookSeat(Passenger p) {
        if (p == null) {
            System.out.println("Invalid passenger.");
            return false;
        }

        if (isDuplicatePassenger(p)) {
            System.out.println("Passenger " + p.getName() + " is already booked. Duplicate booking not allowed.");
            return false;
        }

        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p;
                System.out.println("Passenger " + p.getName() + " booked successfully.");
                return true;
            }
        }

        System.out.println("Flight Full! Booking failed for Passenger: " + p.getName());
        return false;
    }

    private boolean isDuplicatePassenger(Passenger p) {
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null && seats[i].getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    public void displaySeatStatus() {
        System.out.println("\nSeat Status:");
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                System.out.println("Seat " + (i + 1) + ": Empty");
            } else {
                System.out.println("Seat " + (i + 1) + ": " 
                        + seats[i].getName() + " (ID: " + seats[i].getId() + ")");
            }
        }
    }
}

public class FlightReservationSystem {
    public static void main(String[] args) {
        Flight flight = new Flight(5);

        Passenger p1 = new Passenger("Aman", 101);
        Passenger p2 = new Passenger("Rahul", 102);
        Passenger p3 = new Passenger("Riya", 103);
        Passenger p4 = new Passenger("Aman", 101);   // Duplicate
        Passenger p5 = new Passenger("Neha", 104);
        Passenger p6 = new Passenger("Karan", 105);
        Passenger p7 = new Passenger("Simran", 106); // Flight full

        flight.bookSeat(p1);
        flight.bookSeat(p2);
        flight.bookSeat(p3);
        flight.bookSeat(p4); // Duplicate case
        flight.bookSeat(p5);
        flight.bookSeat(p6);
        flight.bookSeat(p7); // Full case

        flight.displaySeatStatus();
    }
}