package lk.ijse.dto;

import lk.ijse.entity.Item;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class ItemDTO extends Item {
    private String Code;
    private String Description;
    private double unit_price ;
    private int qty_on_hand ;
    private double buying_price;
    private String Supplier_id;

}
