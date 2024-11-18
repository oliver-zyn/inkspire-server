package br.com.ravenstore.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ravenstore.server.dto.ThemeDTO;
import br.com.ravenstore.server.model.Theme;
import br.com.ravenstore.server.service.ThemeService;

@RestController
@RequestMapping("api/themes")
public class ThemeController {
  private final ThemeService themeService;
  private final ModelMapper modelMapper;

  public ThemeController(ThemeService themeService, ModelMapper modelMapper) {
    this.themeService = themeService;
    this.modelMapper = modelMapper;
  }

  private ThemeDTO convertToResponseDto(Theme theme) {
    return modelMapper.map(theme, ThemeDTO.class);
  }

  @GetMapping
  public ResponseEntity<List<ThemeDTO>> findAll() {
    List<ThemeDTO> themes = themeService.findAll().stream()
        .map(this::convertToResponseDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(themes);
  }
}
