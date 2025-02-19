package br.com.ravenstore.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.ravenstore.server.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT p FROM Product p JOIN p.skus s JOIN p.themes t WHERE "
            + "(:categoryIds IS NULL OR p.category.id IN :categoryIds) AND "
            + "(:color IS NULL OR s.colorAttribute.attributeValue = :color) AND "
            + "(:sizeAttr IS NULL OR s.sizeAttribute.attributeValue = :sizeAttr) AND "
            + "(:minPrice IS NULL OR s.price >= :minPrice) AND "
            + "(:maxPrice IS NULL OR s.price <= :maxPrice) AND "
            + "(:themeIds IS NULL OR t.id IN :themeIds)")

    Page<Product> findFilteredProductsPaginated(
            @Param("categoryIds") List<Long> categoryIds,
            @Param("themeIds") List<Long> themeIds,
            @Param("color") String color,
            @Param("sizeAttr") String sizeAttr,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            Pageable pageable);

}
