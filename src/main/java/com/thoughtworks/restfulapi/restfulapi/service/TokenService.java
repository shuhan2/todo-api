package com.thoughtworks.restfulapi.restfulapi.service;

import com.thoughtworks.restfulapi.restfulapi.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {


    protected static SecureRandom random = new SecureRandom();

    public static User getPrincipal() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public synchronized String generateSession(String id) {
        String signature = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, "secret-key")
                .claim("id", id)
                .compact();
//        long longToken = Math.abs( random.nextLong() );
//        String random = Long.toString( longToken, 16 );
        return signature;
    }

    public String parseToken(String token) {

        String signature = token;
        String cliams = Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(signature)
                .getBody().get("userId", String.class);
        return cliams;

    }
}
