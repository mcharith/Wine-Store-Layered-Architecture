package lk.ijse.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Data
public class OrderDetailDTO {
    private String Order_id;
    private String Item_code;
    private int qty;
    private double unitPrice;
}


