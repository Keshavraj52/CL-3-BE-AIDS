import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
public class HotelServer extends UnicastRemoteObject implements HotelServiceInterface {
 private HashMap<String, String> bookings = new HashMap<>();
 HotelServer() throws RemoteException {
 }
 public String bookRoom(String guestName) throws RemoteException {
 if (bookings.containsKey(guestName)) {
 return "Room already booked for: " + guestName;
 }
 bookings.put(guestName, "Room Booked");
 return "Room successfully booked for: " + guestName;
 }
 public String cancelBooking(String guestName) throws RemoteException {
 if (!bookings.containsKey(guestName)) {
 return "No booking found for: " + guestName;
 }
 bookings.remove(guestName);
 return "Booking cancelled for: " + guestName;
 }
 public String viewBookings() throws RemoteException {
 if (bookings.isEmpty()) {
 return "No current bookings.";
 }
 return "Current Bookings: " + bookings.keySet().toString();
 }
 public static void main(String[] args) {
 try {
 HotelServer server = new HotelServer();
 Registry registry = LocateRegistry.createRegistry(6000);
 registry.rebind("HotelService", server);
 System.out.println("Hotel Server is running and ready...");
 } catch (Exception e) {
 System.out.println("Server Error: " + e.getMessage());
 }
 }
}