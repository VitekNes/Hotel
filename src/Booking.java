import java.time.LocalDate;
import java.util.List;

public class Booking {
    private List<Guest> guestList;
    private Room room;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private boolean isWorkVacation;

    public Booking(List<Guest> guestList, Room room, LocalDate arrivalDate, LocalDate departureDate, boolean isWorkVacation) {
        this.guestList = guestList;
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.isWorkVacation = isWorkVacation;
    }

    public Booking(List<Guest> guestList, Room room, LocalDate arrivalDate, LocalDate departureDate) {
        this(guestList, room, arrivalDate, departureDate, false);
    }
    public Booking(List<Guest> guestList, Room room) {
        this(guestList, room, LocalDate.now(),LocalDate.now().plusDays(6));
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public boolean isWorkVacation() {
        return isWorkVacation;
    }

    public void setWorkVacation(boolean workVacation) {
        isWorkVacation = workVacation;
    }
}
