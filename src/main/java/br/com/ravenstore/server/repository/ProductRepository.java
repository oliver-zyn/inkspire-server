package br.com.ravenstore.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ravenstore.server.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}