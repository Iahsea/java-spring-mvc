package vn.iahsea.laptopshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iahsea.laptopshop.domain.Product;
import vn.iahsea.laptopshop.domain.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    // Product save(Product iahsea);

    // List<Product> findAll();

    // void deleteById(long id);

    // Optional<Product> findById(long id);
}
