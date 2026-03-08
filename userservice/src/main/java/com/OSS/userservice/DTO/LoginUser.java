package com.OSS.userservice.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {
    @NotBlank
    private Long phoneNo;
    @NotBlank
    private String password;
}
