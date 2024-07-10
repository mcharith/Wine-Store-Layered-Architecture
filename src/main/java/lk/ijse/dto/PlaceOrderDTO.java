package lk.ijse.dto;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class PlaceOrderDTO {
    private OrderDTO order;
    private List<OrderDetailDTO> odList;
}
