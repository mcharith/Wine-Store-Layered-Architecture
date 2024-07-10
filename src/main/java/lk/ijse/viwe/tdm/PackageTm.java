package lk.ijse.viwe.tdm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
public class PackageTm {
    private String packageId;
    private String Description;
    private  double Price;
    private int Qty ;
}
