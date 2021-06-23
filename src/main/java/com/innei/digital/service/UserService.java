package com.innei.digital.service;

import com.innei.digital.entity.User;
import com.innei.digital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        var users = this.userRepository.findAll();
        for (User user : users) {
            // HACK: un-select password
            user.setPassword(null);
        }
        return users;
    }

    public User getUserByUsername(String username) {
        var user = this.userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        user.setPassword(null);
        return user;
    }

    public User getUserById(Integer id) {
        var user = this.userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        }

        var $user = user.get();

        $user.setPassword(null);
        return $user;
    }


    public boolean updateUser(User user) {
        // HACK

        var _user = this.userRepository.findByUsername(user.getUsername());
        if (_user == null) {
            return false;
        }

        user.setId(_user.getId());
        user.setCreatedAt(_user.getCreatedAt());
        user.setPassword(_user.getPassword());
        this.userRepository.save(user);
        return true;
    }

    public boolean deleteUser(String username) {
        var user = this.getUserByUsername(username);
        if (user == null) {
            return false;
        }

        this.userRepository.deleteById(user.getId());

        return true;

    }

}
