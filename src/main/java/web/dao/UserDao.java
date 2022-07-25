package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    User updateUser(User User);
    List<User> getAllUsers();
    User getUserById(int id);
    void removeUser(int id);
}
