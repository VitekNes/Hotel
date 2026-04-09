import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int beds;
    private boolean isBalcony;
    private boolean isSeaview;
    private BigDecimal price;

    public Room(int roomNumber, int beds, boolean isBalcony, boolean isSeaview, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.isBalcony = isBalcony;
        this.isSeaview = isSeaview;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public boolean isBalcony() {
        return isBalcony;
    }

    public void setBalcony(boolean balcony) {
        isBalcony = balcony;
    }

    public boolean isSeaview() {
        return isSeaview;
    }

    public void setSeaview(boolean seaview) {
        isSeaview = seaview;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
