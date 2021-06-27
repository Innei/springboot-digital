package com.innei.digital.controller;

import com.innei.digital.entity.User;
import com.innei.digital.service.AuthService;
import com.innei.digital.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "User")
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(path = "/me")
    public Object getMe(HttpServletRequest request) {
        var authorization = request.getHeader("Authorization");
        if (authorization == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "请先登录");
        }
        authorization = authorization.replace("bearer ", "");
        var username = AuthService.getJWTTokenSubject(authorization);
        if (username.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "用户不存在");
        }
        return this.userService.getUserByUsername(username);

    }


    @GetMapping(path = "/")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(path = "/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUserByUsername(username);
    }

//    @GetMapping(path = "/{id}")
//    public User getUser(@PathVariable("id") Integer id) {
//        return this.userService.getUserById(id);
//    }

    @PutMapping(path = "")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User body) {

        var res = this.userService.updateUser(body);
        if (!res) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "修改失败");
        }

    }

    @DeleteMapping(path = "/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("username") String username) {

        var res = this.userService.deleteUser(username);
        if (!res) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "删除失败");
        }

    }

    @Autowired
    private AuthService authService;

    @PostMapping()
    public User createUser(@Valid @RequestBody User body) {
        return this.authService.createUser(body);
    }
}
