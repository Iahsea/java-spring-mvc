package vn.iahsea.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iahsea.laptopshop.domain.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Long>{
    User save(User iahsea);

    List<User> findByEmail(String email);

    List<User> findAll();
}
