package vn.iahsea.laptopshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iahsea.laptopshop.domain.Order;
import vn.iahsea.laptopshop.domain.Product;
import vn.iahsea.laptopshop.domain.Role;
import vn.iahsea.laptopshop.domain.User;
import vn.iahsea.laptopshop.domain.dto.RegisterDTO;
import vn.iahsea.laptopshop.repository.OrderRepository;
import vn.iahsea.laptopshop.repository.ProductRepository;
import vn.iahsea.laptopshop.repository.RoleRepository;
import vn.iahsea.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public UserService(UserRepository userRepository,
            RoleRepository roleRepository,
            ProductRepository productRepository,
            OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

    public User handleSaveUser(User user) {
        User iahsea = this.userRepository.save(user);
        System.out.println(iahsea);
        return iahsea;
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteAUser(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User user = new User();

        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        return user;
    }

    public boolean checkEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public long countUsers() {
        return this.userRepository.count();
    }

    public long countProducts() {
        return this.productRepository.count();
    }

    public long countOrders() {
        return this.orderRepository.count();
    }

}
