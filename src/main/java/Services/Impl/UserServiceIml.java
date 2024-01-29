package Services.Impl;

import Dao.DaoImpl.UserDaoImpl;
import Dao.UserDaoInterFace;
import Models.Users;
import Services.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceIml implements UserService {
private  final UserDaoInterFace userDao = new UserDaoImpl();
    @Override
    public boolean createUserTable() {
        return userDao.createUserTable();
    }

    @Override
    public String saveUser(Users newUser) {
        return userDao.saveUser(newUser);
    }

    @Override
    public Optional<Users> findUserById(Long id) {
        return userDao.findById( id);
    }

    @Override
    public boolean deleteUserById(Long id) {
      this.userDao.deleteUserById(id);
        return false;
    }

    @Override
    public List<Users> findAllUsers() {
        return userDao.findAllUsers();
    }
}
