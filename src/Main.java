import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager();

        Guest guest1 = new Guest("Adéla", "Malíkova", LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest("Jan", "Dvořaček", LocalDate.of(1995, 5, 5));
        guest2.setBirthDate(LocalDate.of(1995, 4, 5));
        System.out.println(guest2.getFirstName() + " " + guest2.getLastName() + " (" + guest2.getBirthDate() + ")");

        Room room1 = new Room(1, 1, true, true, new BigDecimal(1000));
        Room room2 = new Room(2, 1, true, true, new BigDecimal(1000));
        Room room3 = new Room(3, 3, false, true, new BigDecimal(2400));

        List<Guest> list1 = new ArrayList<>();
        list1.add(guest1);
        List<Guest> list2 = new ArrayList<>();
        list2.add(guest1);
        list2.add(guest2);

        Booking booking1 = new Booking(list1, room1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26));
        Booking booking2 = new Booking(list2, room3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14));
        Booking booking3 = new Booking(list2, room3);

        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);

        for(Booking booking : bookings){
            System.out.println(booking.getRoom().getRoomNumber() +", "+ booking.getArrivalDate() +":"+ booking.getDepartureDate());
            for(Guest guest : booking.getGuestList()){
                System.out.println(guest.getFirstName() + " " + guest.getLastName() + " (" + guest.getBirthDate() + ")");
            }
        }
    }
}