package Dao;

import Models.Users;

import java.util.List;
import java.util.Optional;

public interface UserDaoInterFace {

    boolean createUserTable();
   String saveUser (Users newUser);

    Optional<Users> findById(long id);
    boolean deleteUserById(Long id);

    List<Users> findAllUsers();


}
