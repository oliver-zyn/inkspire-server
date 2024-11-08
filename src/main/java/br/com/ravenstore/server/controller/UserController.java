package br.com.ravenstore.server.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ravenstore.server.dto.UserDTO;
import br.com.ravenstore.server.model.User;
import br.com.ravenstore.server.service.UserService;
import br.com.ravenstore.server.shared.GenericResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

  private final UserService userService;
  private final ModelMapper modelMapper;

  public UserController(UserService userService, ModelMapper modelMapper) {
    this.userService = userService;
    this.modelMapper = modelMapper;
  }

  @PostMapping("register")
  public ResponseEntity<GenericResponse> createUser(@RequestBody @Valid UserDTO userDTO) {
    userService.save(modelMapper.map(userDTO, User.class));

    return ResponseEntity.ok(new GenericResponse("Usuário salvo com sucesso!"));
  }

  @PutMapping("{id}")
  public ResponseEntity<GenericResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {
    User updatedUser = userService.findOne(id);
    modelMapper.map(userDTO, updatedUser);
    userService.save(updatedUser);
    return ResponseEntity.ok(new GenericResponse("Usuário atualizado com sucesso!"));
  }
}
