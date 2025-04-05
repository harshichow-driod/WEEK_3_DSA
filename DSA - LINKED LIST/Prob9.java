import java.util.*;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class Prob9 {
    Ticket head;
    Ticket tail;

    public Prob9() {
        this.head = null;
        this.tail = null;
    }

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
        } else {
            tail.next = newTicket;
            tail = newTicket;
        }
    }

    public void removeTicket(int ticketID) {
        if (head == null) return;
        if (head.ticketID == ticketID) {
            head = head.next;
            return;
        }
        Ticket current = head;
        while (current.next != null && current.next.ticketID != ticketID) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != null);
    }

    public void searchTicket(String keyword) {
        Ticket current = head;
        boolean found = false;
        while (current != null) {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No ticket found with the given keyword.");
        }
    }

    public void countTickets() {
        int count = 0;
        Ticket current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total booked tickets: " + count);
    }

    public static void main(String[] args) {
        Prob9 system = new Prob9();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Ticket\n2. Remove Ticket\n3. Display Tickets\n4. Search Ticket\n5. Count Tickets\n6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID, Customer Name, Movie Name, Seat Number, Booking Time: ");
                    int ticketID = sc.nextInt();
                    sc.nextLine();
                    String customerName = sc.nextLine();
                    String movieName = sc.nextLine();
                    String seatNumber = sc.nextLine();
                    String bookingTime = sc.nextLine();
                    system.addTicket(ticketID, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeTicketID = sc.nextInt();
                    system.removeTicket(removeTicketID);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;
                case 5:
                    system.countTickets();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 6);

        sc.close();
    }
}
