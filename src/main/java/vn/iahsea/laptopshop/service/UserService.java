package vn.iahsea.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.iahsea.laptopshop.domain.User;
import vn.iahsea.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public User handleSaveUser(User user){
        User iahsea = this.userRepository.save(user);
        System.out.println(iahsea);
        return iahsea;
    }

    public User getUserById(long id){
        return this.userRepository.findById(id);
    }

    public void deleteAUser(long id){
        this.userRepository.deleteById(id);
    }

}
