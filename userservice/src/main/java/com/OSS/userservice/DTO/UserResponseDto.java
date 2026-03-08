package com.OSS.userservice.DTO;

import com.OSS.userservice.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String userName;
    private Long phoneNo;
    private String email;
    private UserRole role;
}