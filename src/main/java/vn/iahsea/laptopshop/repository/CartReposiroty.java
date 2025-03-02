package vn.iahsea.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iahsea.laptopshop.domain.Cart;
import vn.iahsea.laptopshop.domain.User;

@Repository
public interface CartReposiroty extends JpaRepository<Cart, Long>{
    Cart findByUser(User user);
}
