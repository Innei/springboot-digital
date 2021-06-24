package com.innei.digital.controller;

import com.innei.digital.dto.LoginDto;
import com.innei.digital.entity.User;
import com.innei.digital.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 登陆鉴权控制器
 */
@RestController
@Api(tags = "Auth")
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    //@see: https://www.baeldung.com/spring-boot-bean-validation

    @PostMapping(value = "/login")
    public Object login(@Valid @RequestBody LoginDto body) {
        var username = body.getUsername();
        var password = body.getPassword();

        var isValid = this.authService.validUser(username, password);
        if (isValid) {
            var user = this.authService.findUser(username);
            user.setToken(AuthService.signJWTToken(user.getUsername()));
            user.setPassword(null);

            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误");
        }

    }

    @ApiOperation("register")
    @PostMapping(value = "/register")
    public User register(@Valid @RequestBody User body) {
        return this.authService.createUser(body);
    }

    @GetMapping(path = "/check_logged")
    public Object check(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        token = token.replace("bearer ", "");
        if(token.isEmpty()) {
            return new OK(false);
        }
        var res = AuthService.validJWTToken(token);
        return new OK(res);
    }
}

@Data
class OK {
    public OK(boolean ok) {
        this.ok = ok ? 1 : 0;
    }

    public Integer ok;
}