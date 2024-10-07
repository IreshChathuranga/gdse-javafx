package lk.ijse.gdse.Super.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String customerId;
    private String name;
    private String nic;
    private String email;
    private String phone;
}

