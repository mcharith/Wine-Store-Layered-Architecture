package lk.ijse.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private String Order_id;
    private String Customer_id;
    private Date Date;
    List<PackageDetailsDTO>packageDetailsDTOS;

    public OrderDTO(String order_id, String customer_id, java.util.Date date, List<PackageDetailsDTO> packageDetailsDTOS) {
        Order_id = order_id;
        Customer_id = customer_id;
        Date = date;
        this.packageDetailsDTOS = packageDetailsDTOS;
    }

    public List<PackageDetailsDTO> getPackageDetailsDTOS() {
        return packageDetailsDTOS;
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

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public OrderDTO(String order_id, String customer_id, java.util.Date date) {
        Order_id = order_id;
        Customer_id = customer_id;
        Date = date;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "Order_id='" + Order_id + '\'' +
                ", Customer_id='" + Customer_id + '\'' +
                ", Date=" + Date +
                '}';
    }
}
