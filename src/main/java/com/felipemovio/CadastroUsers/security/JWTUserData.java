package com.felipemovio.CadastroUsers.security;

import com.felipemovio.CadastroUsers.model.Role;
import lombok.Builder;

import java.util.List;

@Builder
public record JWTUserData(Long userId, String email, List<String> roles ){
}
