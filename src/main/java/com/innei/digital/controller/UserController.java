package com.innei.digital.controller;

import com.innei.digital.entity.User;
import com.innei.digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;


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

    @PutMapping(path = "/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("username") String username, @RequestBody User body) {

        var res = this.userService.updateUser(body);
        if (!res) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "修改失败");
        }

    }

    @DeleteMapping(path = "/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("username") String username) {

        var res = this.userService.deleteUser(username);
        if (res == false) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "删除失败");
        }

    }
}
