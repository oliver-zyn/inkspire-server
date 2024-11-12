package br.com.ravenstore.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ravenstore.server.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
  List<Address> findByUserId(Long userId);
}

