package com.felipemovio.CadastroUsers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private RegisterResponseDTO user;
}
