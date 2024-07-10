package lk.ijse.dto;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class PlacePackageDTO {
    private OrderDTO order;
    private List<PackageDetailsDTO> pdList;
}
