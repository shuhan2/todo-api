package com.thoughtworks.restfulapi.restfulapi.security;

import com.thoughtworks.restfulapi.restfulapi.model.User;
import com.thoughtworks.restfulapi.restfulapi.service.TokenService;
import jdk.nashorn.internal.ir.annotations.Immutable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpHandler;
import java.io.IOException;
import java.security.Security;
import java.util.ArrayList;


@Component
public class LoginFilter extends OncePerRequestFilter {


    @Autowired
    TokenService tokenService;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//
//        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (header != null) {
//            if (!header.equals("haha")) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//                return;
//            }
//            User user = new User(5, "zuozuo", "aljdks");
//
//            SecurityContextHolder.getContext().setAuthentication(
//                    new UsernamePasswordAuthenticationToken(
//                            user, "", new ArrayList<>()));
//        }
//    }}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header != null) {
//            Long userId = tokenService.generateSession(header);
            String userToken = tokenService.parseToken(header);
            if (userToken == "") {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(userToken, "", new ArrayList<>()));

        }
        filterChain.doFilter(request, response);
    }
}

