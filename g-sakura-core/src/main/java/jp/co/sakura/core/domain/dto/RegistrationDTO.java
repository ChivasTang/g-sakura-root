package jp.co.sakura.core.domain.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class RegistrationDTO {
    private String username;
    private String password;
    private String confirm;
}
