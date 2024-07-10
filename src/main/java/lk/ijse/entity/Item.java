package lk.ijse.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Item {
    private String Code;
    private String Description;
    private double unit_price ;
    private int qty_on_hand ;
    private double buying_price;
    private String Supplier_id;

    public Item(String code, String description, double unitPrice, int qtyOnHand) {
    }
}
