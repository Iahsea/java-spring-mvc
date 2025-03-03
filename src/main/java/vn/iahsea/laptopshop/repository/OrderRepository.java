package vn.iahsea.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iahsea.laptopshop.domain.Order;
import vn.iahsea.laptopshop.domain.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    List<Order> findByUser(User user);
}
