package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StaffDTO {
    private String Staff_id;
    private String Name;
    private String Address;
    private String Age;
    private String Contact_number;
    private String Job_Role;
}
