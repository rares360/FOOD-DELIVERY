package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Objects;

public class Order implements Serializable {
    private int orderId;
    private int clientId;
    private LocalDateTime orderTime;


    public Order(int orderId, int clientId){
        this.orderId=orderId;
        this.clientId=clientId;
        this.orderTime=LocalDateTime.now();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public int hashCode(){
        return Objects.hash(orderId);
    }
    @Override
    public String toString() {
        return "\nOrder{" +
                "orderId= " + orderId +
                ", clientId= " + clientId +
                ", orderTime= " + orderTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Order order=(Order) obj;
        return orderId==order.getOrderId();
    }
}
