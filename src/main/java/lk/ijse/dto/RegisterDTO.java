package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class RegisterDTO {
    private String User_id;
    private String First_name;
    private String Last_name;
    private String Email;
    private String Password;
}
