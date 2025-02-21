package br.gabnsoares.dev.demojpa.service;

import br.gabnsoares.dev.demojpa.controller.dto.CreateUserDto;
import br.gabnsoares.dev.demojpa.entity.UserEntity;
import br.gabnsoares.dev.demojpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(CreateUserDto dto) {

        var entity = new UserEntity();
        entity.setName(dto.name());
        entity.setAge(dto.age());
        entity.setCreatedAt(LocalDateTime.now());
        return userRepository.save(entity);
    }
}
