package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class ItemDetailsDTO {
    private String Supplier_id;
    private String Item_code;
    private int Qty;
    private double unitPrice;
}
