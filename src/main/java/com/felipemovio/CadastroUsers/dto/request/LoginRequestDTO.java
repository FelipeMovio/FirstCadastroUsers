package com.felipemovio.CadastroUsers.dto.request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String senha;
}
