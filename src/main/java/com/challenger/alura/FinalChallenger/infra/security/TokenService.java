package com.challenger.alura.FinalChallenger.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import com.challenger.alura.FinalChallenger.domain.usuarios.Usuario;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("api game")
                    .withSubject(usuario.getLogin())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(genearFechaExpiracion())
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public /*String*/DecodedJWT getSubject(String token){
        JWTVerifier verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("api game")
                    .build();
            return verifier.verify(token);
        } catch (JWTVerificationException exception){
            System.out.println("La excepcion encontrada es: "+exception);
        }
        if (verifier.getClass()==null){
            throw new RuntimeException("Verifier invalido");
        }
        System.out.println("Se encontro y se imprime: "+verifier);
        return verifier.verify(token);
    }

    private Instant genearFechaExpiracion(){
        return LocalDateTime.now().plusHours(5000).toInstant(ZoneOffset.of("-05:00"));
    }
}
