package lk.ijse.entity;

import lombok.*;

public class OrderDetail {
    private String Order_id;
    private String Item_code;
    private int qty;
    private double unitPrice;

    public OrderDetail(String order_id, String item_code, int qty, double unitPrice) {
        Order_id = order_id;
        Item_code = item_code;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(String order_id) {
        Order_id = order_id;
    }

    public String getItem_code() {
        return Item_code;
    }

    public void setItem_code(String item_code) {
        Item_code = item_code;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "Order_id='" + Order_id + '\'' +
                ", Item_code='" + Item_code + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}


