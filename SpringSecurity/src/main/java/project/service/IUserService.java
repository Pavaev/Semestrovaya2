package project.service;

import project.model.Town;
import project.model.User;

import java.util.ArrayList;

/**
 * Created by Daniel Shchepetov on 22.04.2016.
 */
public interface IUserService {
    void add(User user);
    ArrayList<Town> getTowns();
}
