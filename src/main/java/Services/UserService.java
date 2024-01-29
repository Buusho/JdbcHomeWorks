package Services;

import Models.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {



    boolean createUserTable();
    String saveUser (Users newUser);

    Optional<Users> findUserById(Long id);
    boolean deleteUserById(Long id);

    List<Users> findAllUsers();
}
