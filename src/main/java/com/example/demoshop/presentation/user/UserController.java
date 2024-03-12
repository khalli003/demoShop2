package com.example.demoshop.presentation.user;

import com.example.demoshop.application.user.UserService;
import com.example.demoshop.domain.entity.User;
import com.example.demoshop.presentation.user.dto.commands.CreateUserCommand;
import com.example.demoshop.presentation.user.dto.commands.UpdateUserCommand;
import com.example.demoshop.presentation.user.dto.queries.UserQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
class UserController {

    private UserService service;
    private ModelMapper modelMapper;

    @GetMapping
    public List<UserQuery> getAll() {
        return service.getAll().stream()
                .map(user -> modelMapper.map(user, UserQuery.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserQuery getById(@PathVariable Long id) {
        return modelMapper.map(service.getById(id), UserQuery.class);
    }

    @PostMapping
    public UserQuery create(@RequestBody CreateUserCommand command) {
        User userFromCommand = modelMapper.map(command, User.class);

        User user = service.create(userFromCommand);

        return modelMapper.map(user, UserQuery.class);
    }

    @PutMapping("/{id}")
    public UserQuery update(@PathVariable Long id, @RequestBody UpdateUserCommand command) {
        User userFromCommand = modelMapper.map(command, User.class);

        User user = service.update(id, userFromCommand);

        return modelMapper.map(user, UserQuery.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}