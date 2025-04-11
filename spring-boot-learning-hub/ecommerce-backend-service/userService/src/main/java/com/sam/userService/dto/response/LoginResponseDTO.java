package com.sam.userService.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {

    private Long userId;
    private String username;
    private String email;
    private List<String> roles;
    private String jwtToken;
}
