package br.com.ravenstore.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ravenstore.server.model.Theme;
import br.com.ravenstore.server.repository.ThemeRepository;

@Service
public class ThemeService {
  private final ThemeRepository themeRepository;

  public ThemeService(ThemeRepository themeRepository) {
    this.themeRepository = themeRepository;
  }

  public List<Theme> findAll() {
    return themeRepository.findAll();
  }
}
