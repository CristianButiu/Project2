import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Order {
    private int orderID;
    private String clientID;
    private LocalDateTime dataAndHour;
    public Order(int orderID, String clientID, LocalDateTime dataAndHour)
    {
        this.orderID = orderID;
        this.clientID = clientID;
        this.dataAndHour = dataAndHour;
    }

    public int getOrderID() {
        return orderID;

    }

    public String getClientID() {
        return clientID;
    }

    public LocalDateTime getNow() {
        return dataAndHour;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setNow(LocalDateTime now) {
        this.dataAndHour = now;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, clientID, dataAndHour);
    }
}
