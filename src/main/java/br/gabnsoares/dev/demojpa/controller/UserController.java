package br.gabnsoares.dev.demojpa.controller;

import br.gabnsoares.dev.demojpa.controller.dto.CreateUserDto;
import br.gabnsoares.dev.demojpa.controller.dto.UpdateUserDto;
import br.gabnsoares.dev.demojpa.entity.UserEntity;
import br.gabnsoares.dev.demojpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto dto) {

        var user = userService.createUser(dto);

        return ResponseEntity.created(URI.create("/user/" + user.getUserId())).build();

    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> listAll() {

        var users = userService.findAll();

        return ResponseEntity.ok(users);
    }

    @GetMapping(path ="/{userId}")
    public ResponseEntity<UserEntity> findById(@PathVariable("userId") Long userId)  {

        var user = userService.findById(userId);

        return user.isPresent() ?
                ResponseEntity.ok(user.get()) :
                ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable("userId") Long userId,
                                           @RequestBody UpdateUserDto dto) {
        var user = userService.updateById(userId, dto);

        return user.isPresent() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") Long userId) {

        var userDeleted = userService.deleteById(userId);

        return userDeleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
