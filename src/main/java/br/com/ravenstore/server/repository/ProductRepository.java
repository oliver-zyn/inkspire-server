package br.com.ravenstore.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.ravenstore.server.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT p FROM Product p JOIN p.skus s WHERE "
     + "(:categoryId IS NULL OR p.category.id = :categoryId) AND "
     + "(:color IS NULL OR s.colorAttribute.attributeValue = :color) AND "
     + "(:size IS NULL OR s.sizeAttribute.attributeValue = :size) AND "
     + "(:minPrice IS NULL OR s.price >= :minPrice) AND "
     + "(:maxPrice IS NULL OR s.price <= :maxPrice)")
     
Page<Product> findFilteredProductsPaginated(
    @Param("categoryId") Long categoryId,
    @Param("color") String color,
    @Param("size") String size,
    @Param("minPrice") Double minPrice,
    @Param("maxPrice") Double maxPrice,
    Pageable pageable);
}
