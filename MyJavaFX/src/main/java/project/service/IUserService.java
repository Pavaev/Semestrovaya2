package project.service;

import project.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Shchepetov on 11.05.2016.
 */
public interface IUserService {

    User getUserById(int id);
    List<User> getUsers();
    User createUser(User user);
    void deleteById(int id);
    void deleteAll();
    User updateUser(User temp, User user);
    boolean isExist(Integer id);
    boolean isExist(User user);
}