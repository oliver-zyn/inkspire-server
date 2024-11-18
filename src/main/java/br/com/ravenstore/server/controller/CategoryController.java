package br.com.ravenstore.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ravenstore.server.dto.CategoryDTO;
import br.com.ravenstore.server.model.Category;
import br.com.ravenstore.server.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
  private final CategoryService categoryService;
  private final ModelMapper modelMapper;

  public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
    this.categoryService = categoryService;
    this.modelMapper = modelMapper;
  }

  private CategoryDTO convertToResponseDto(Category category) {
    return modelMapper.map(category, CategoryDTO.class);
  }

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> findAll() {
    List<CategoryDTO> categories = categoryService.findAll().stream()
        .map(this::convertToResponseDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(categories);
  }
}
