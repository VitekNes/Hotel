import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingManager manager = fillBookings();

        System.out.println("Počet pracovních pobytů: " +manager.getNumberOfWorkingBookings()+"\n");
        System.out.println("Průměrný počet hostů na rezervaci: "+manager.getAverageGuests()+"\n");

        List<Booking> topHolidayBookings= manager.getTopHolidayBookings();
        System.out.println("Prvních osm rekreačních rezervací:");
        for(Booking booking : topHolidayBookings){
            System.out.println("Rezervace pro: " +booking.getGuestList().getFirst().getFirstName()+ " " +booking.getGuestList().getFirst().getLastName()+ " (" +booking.getGuestList().getFirst().getBirthDate()+ ") termín: " +booking.getArrivalDate()+ " - " +booking.getDepartureDate()+ " pracovní pobyt: " +(booking.isWorkVacation()?"ano":"ne"));
        }
        System.out.println("\nStatistiky hostů:");
        manager.printGuestStatistics();

        System.out.println("\nFormátovaný výpis všech rezervací v systému:");
        for(Booking booking : manager.getBookings()){
            System.out.println(booking.getFormatedSummary());
        }

        /*BookingManager manager = new BookingManager();

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

        manager.addBooking(booking1);
        manager.addBooking(booking2);
        manager.addBooking(booking3);

        for(Booking booking : manager.getBookings()){
            System.out.println(booking.getRoom().getRoomNumber() +", "+ booking.getArrivalDate() +":"+ booking.getDepartureDate());
            for(Guest guest : booking.getGuestList()){
                System.out.println(guest.getFirstName() + " " + guest.getLastName() + " (" + guest.getBirthDate() + ")");
            }
        }

        System.out.println(manager.getAverageGuests());
        manager.printGuestStatistics();*/
    }

    public static BookingManager fillBookings(){
        BookingManager manager = new BookingManager();

        Guest guest1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
        Guest guest2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
        Guest guest3 = new Guest("Karolína", "Tmavá");

        Room room1 = new Room(1, 1, true, true, new BigDecimal(1000));
        Room room2 = new Room(2, 1, true, true, new BigDecimal(1000));
        Room room3 = new Room(3, 3, false, true, new BigDecimal(2400));

        List<Guest> list1 = new ArrayList<>();
        list1.add(guest1);
        manager.addBooking(new Booking(list1, room1, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), true));

        List<Guest> list2 = new ArrayList<>();
        list2.add(guest2);
        manager.addBooking(new Booking(list2, room2, LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), false));

        List<Guest> list3 = new ArrayList<>();
        list3.add(guest3);
        list3.add(guest1);
        manager.addBooking(new Booking(list3, room3, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), true));

        for(int i = 0; i < 10; i++){
            List<Guest> tempList = new ArrayList<>();
            tempList.add(guest3);
            manager.addBooking(new Booking(tempList, room2, LocalDate.of(2023, 8, (i*2)+1), LocalDate.of(2023, 8, (i+1)*2), false));

        }
        return manager;
    }
}