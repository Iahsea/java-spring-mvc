package vn.iahsea.laptopshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iahsea.laptopshop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    // Product save(Product iahsea);

    // List<Product> findAll();

    // void deleteById(long id);

    // Optional<Product> findById(long id);
}
