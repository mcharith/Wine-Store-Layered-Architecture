package lk.ijse.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Data
public class PackageDetailsDTO {
    private String Order_id;
    private String Package_id;
    private int qty;
    private double unitPrice;
}
