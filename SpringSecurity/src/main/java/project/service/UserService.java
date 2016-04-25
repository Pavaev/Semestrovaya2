package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Town;
import project.model.User;
import project.repo.ComplaintRepository;
import project.repo.TownRepository;
import project.repo.UserRepository;

import java.util.ArrayList;

/**
 * Created by Daniel Shchepetov on 22.04.2016.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public void add(User user) {
        userRepo.save(user);
    }
    public User getOne(int id){ return userRepo.findOne(id);}

}
