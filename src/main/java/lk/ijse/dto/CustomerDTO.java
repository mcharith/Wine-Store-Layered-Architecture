package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class CustomerDTO {
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusNum;
}
