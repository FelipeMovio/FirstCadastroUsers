package com.felipemovio.CadastroUsers.dto.response;

import com.felipemovio.CadastroUsers.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class RegisterResponseDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private String email;

}
