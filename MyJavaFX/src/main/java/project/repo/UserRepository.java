package project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.User;


/**
 * Created by Daniel Shchepetov on 11.05.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    User findByUsernameAndPhone(String username, int phone);
}
