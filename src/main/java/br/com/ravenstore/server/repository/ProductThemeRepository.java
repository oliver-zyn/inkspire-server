package br.com.ravenstore.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ravenstore.server.model.ProductTheme;

@Repository
public interface ProductThemeRepository extends JpaRepository<ProductTheme, Long> {
}
