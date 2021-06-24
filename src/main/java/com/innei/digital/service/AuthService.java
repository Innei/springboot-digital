package com.innei.digital.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.innei.digital.entity.User;
import com.innei.digital.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.SecureRandom;
import java.util.Date;

import static com.innei.digital.security.JWTAuthenticationFilter.SECRET;
import static com.innei.digital.security.JWTAuthenticationFilter.TOKEN_PREFIX;


@Service
public class AuthService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static final String SECRET = "asfasfgarascadgasd";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/auth/register";


    public User createUser(User user) {
        /**
         * password salt hash
         *@see: https://reflectoring.io/spring-security-password-handling/
         */


        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // set other metadata
        user.setCreatedAt(new Date());
        var doc = this.userRepository.save(user);
        doc.setPassword(null);
        return doc;
    }

    public User findUser(String username) {
        return this.userRepository.findByUsername((username));
    }

    public boolean validUser(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        return this.bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    public static String signJWTToken(String username) {
        String token = JWT.create()
                .withSubject(username)
                .sign(Algorithm.HMAC512(SECRET.getBytes()));


        return token;
    }


    public static boolean validJWTToken(String token) {
        if (token == null || token.isEmpty()) return false;
        try {
            var sub = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();
            return sub != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getJWTTokenSubject(String token) {
        if (token == null || token.isEmpty()) return "";

        var sub = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                .build()
                .verify(token)
                .getSubject();

        return sub;
    }

}

