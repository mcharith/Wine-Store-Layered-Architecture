package lk.ijse.dto;

import java.util.Date;
import java.util.List;

public class OrderPlaceDTO {
    private String Order_id;
    private String Customer_id;
    private Date date;
    List<OrderDetailDTO> orderDetailDTOS;

    public OrderPlaceDTO(String order_id, String customer_id, Date date, List<OrderDetailDTO> orderDetailDTOS) {
        Order_id = order_id;
        Customer_id = customer_id;
        this.date = date;
        this.orderDetailDTOS = orderDetailDTOS;
    }

    public List<OrderDetailDTO> getOrderDetailDTOS() {
        return orderDetailDTOS;
    }

    public OrderPlaceDTO(String order_id, String customer_id, Date date) {
        Order_id = order_id;
        Customer_id = customer_id;
        this.date = date;
    }

    public String getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(String order_id) {
        Order_id = order_id;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderPlaceDTO{" +
                "Order_id='" + Order_id + '\'' +
                ", Customer_id='" + Customer_id + '\'' +
                ", date=" + date +
                '}';
    }
}
