package vn.iahsea.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iahsea.laptopshop.domain.Cart;
import vn.iahsea.laptopshop.domain.CartDetail;
import vn.iahsea.laptopshop.domain.Product;



@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
    
    boolean existsByCartAndProduct(Cart cart, Product product);

    CartDetail findByCartAndProduct(Cart cart, Product product);
}
