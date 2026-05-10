import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class HotelClient {
 public static void main(String[] args) {
 try {
 Registry registry = LocateRegistry.getRegistry("localhost", 6000);
 HotelServiceInterface hotel = (HotelServiceInterface) registry.lookup("HotelService");
 Scanner sc = new Scanner(System.in);
 int choice = 0;
 while (choice != 3) {
 System.out.println("\n1. Book a Room");
 System.out.println("2. Cancel Booking");
 System.out.println("3. Exit");
 System.out.print("Enter your choice: ");
 choice = sc.nextInt();
 sc.nextLine();
 switch (choice) {
 case 1:
 System.out.print("Enter Guest Name: ");
 String guestBook = sc.nextLine();
 System.out.println(hotel.bookRoom(guestBook));
 break;
 case 2:
 System.out.print("Enter Guest Name: ");
 String guestCancel = sc.nextLine();
 System.out.println(hotel.cancelBooking(guestCancel));
 break;
 case 3:
 System.out.println("Exiting...");
 break;
 default:
 System.out.println("Invalid choice!");
 }
 }
 sc.close();
 } catch (Exception e) {
 System.out.println("Client Error: " + e.getMessage());
 }
 }
}