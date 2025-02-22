package vn.iahsea.laptopshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.iahsea.laptopshop.domain.User;

@Repository
public interface  UserRepository extends CrudRepository<User, Long>{
    User save(User iahsea);
}
