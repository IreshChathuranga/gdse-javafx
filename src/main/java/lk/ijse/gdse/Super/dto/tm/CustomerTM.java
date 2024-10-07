package lk.ijse.gdse.Super.dto.tm;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTM {
    private String customerId;
    private String name;
    private String nic;
    private String email;
    private String phone;
}
