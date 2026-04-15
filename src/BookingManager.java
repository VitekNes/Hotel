import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();

    //work functions
    public void addBooking(Booking booking){
        bookingList.add(booking);
    }
    public Booking getBooking(int index){
        return bookingList.get(index);
    }
    public List<Booking> getBookings(){
        return bookingList;
    }
    public void clearBookings(){
        bookingList.clear();
    }
    //statistic functions
    public int getNumberOfWorkingBookings(){
        int count = 0;
        for(Booking booking : bookingList){
            if(booking.isWorkVacation()){
                count++;
            }
        }
        return count;
    }
    public double getAverageGuests(){
        int count = 0;
        for(Booking booking : bookingList){
            count += booking.getGuestList().size();
        }
        return (double) count/bookingList.size();
    }
    public List<Booking> getTopHolidayBookings(int ammount){
        List<Booking> temp = new ArrayList<>();
        int i = 0;
        while(temp.size() < ammount && i < bookingList.size()){
            if(! bookingList.get(i).isWorkVacation()){
                temp.add(bookingList.get(i));
            }
            i++;
        }
        return temp;
    }
    public void printGuestStatistics(){
        int singleBooking = 0;
        int doubleBooking = 0;
        int multiBooking = 0;
        for(Booking booking : bookingList){
            if(booking.getGuestList().size() == 1){
                singleBooking += 1;
            } else if(booking.getGuestList().size() == 2){
                doubleBooking += 1;
            } else{
                multiBooking += 1;
            }
        }
        System.out.println("Rezervace s jednime hostem: " + singleBooking);
        System.out.println("Rezervace se dvema hosty: " + doubleBooking);
        System.out.println("Rezervace s vice hosty: " + multiBooking);
    }
}
