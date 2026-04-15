import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    //work functions
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
    //statistic functions
    public Long getBookingLenght(){
        return Duration.between(arrivalDate, departureDate).toDays();
    }

    public BigDecimal getTotalPrice(){
        return room.getPrice().multiply(BigDecimal.valueOf(Duration.between(arrivalDate, departureDate).toDays()));
    }

    public String getFormatedSummary(){
        return arrivalDate.format(DateTimeFormatter.ofPattern("d. M. YYYY"))+ " až " +departureDate.format(DateTimeFormatter.ofPattern("d. M. YYYY"))+ ": " +guestList.getFirst().getFirstName()+ " " +guestList.getFirst().getLastName()+ " (" +guestList.getFirst().getBirthDate().format(DateTimeFormatter.ofPattern("d. M. YYYY"))+ ")[" +guestList.size()+ ", " +room.isSeaview()+ "] za " +room.getPrice().multiply(BigDecimal.valueOf(Duration.between(arrivalDate, departureDate).toDays()))+ "Kč.";
    }
}
