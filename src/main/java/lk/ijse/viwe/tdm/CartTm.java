package lk.ijse.viwe.tdm;

import com.jfoenix.controls.JFXButton;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Data
public class CartTm {
    private String code;
    private String description;
    private int qty;
    private double unitPrice;
    private double total;
    private JFXButton btnRemove;
}
