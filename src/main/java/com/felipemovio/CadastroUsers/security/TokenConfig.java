package com.felipemovio.CadastroUsers.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.felipemovio.CadastroUsers.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Users user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withClaim("userId", user.getId())
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(86400)) // 24h duração do token
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decoded = JWT.require(algorithm).build().verify(token);

            return Optional.of(JWTUserData.builder()
                    .userId(decoded.getClaim("userId").asLong())
                    .email(decoded.getSubject())
                    .build());
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
    }
}
