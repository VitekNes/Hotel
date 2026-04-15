import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking booking){
        bookingList.add(booking);
    }
    public Booking getBooking(int index){
        return bookingList.get(index);
    }
    public List getBookings(){
        return bookingList;
    }
    public void clearBookings(){
        bookingList.clear();
    }
}
