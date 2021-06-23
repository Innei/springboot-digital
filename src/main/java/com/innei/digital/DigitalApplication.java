package com.innei.digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

@SpringBootApplication
public class DigitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalApplication.class, args);
    }


    private final int strength = 10;
    private final BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder(strength, new SecureRandom());

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return this.bCryptPasswordEncoder;
    }

}
