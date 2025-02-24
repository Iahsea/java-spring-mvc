package vn.iahsea.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iahsea.laptopshop.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    Role findByName(String name);
}
