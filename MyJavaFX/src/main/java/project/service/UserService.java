package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.model.User;
import project.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Shchepetov on 11.05.2016.
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public User getUserById(int id) {
        return userRepo.findOne(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepo.delete(id);
    }

    @Override
    public void deleteAll() {
        userRepo.deleteAll();
    }

    @Override
    public User updateUser(User temp, User user) {
        user.setId(temp.getId());
        return userRepo.save(user);
    }

    @Override
    public boolean isExist(Integer id) {
        return userRepo.exists(id);
    }

    @Override
    public boolean isExist(User user) {
        return userRepo.findByUsernameAndPhone(user.getUsername(), user.getPhone())!=null;
    }


}
