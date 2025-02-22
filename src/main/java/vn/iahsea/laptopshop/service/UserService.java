package vn.iahsea.laptopshop.service;

import org.springframework.stereotype.Service;

import vn.iahsea.laptopshop.domain.User;
import vn.iahsea.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user){
        User iahsea = this.userRepository.save(user);
        System.out.println(iahsea);
        return iahsea;
    }
}
