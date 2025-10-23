package com.felipemovio.CadastroUsers.security;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId,String email ) {
}
