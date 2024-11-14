package br.com.ravenstore.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ravenstore.server.model.Category;
import br.com.ravenstore.server.repository.CategoryRepository;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }
}
