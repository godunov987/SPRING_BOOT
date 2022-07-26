package web.servise;


import web.model.User;

import java.util.List;

public interface UserServise {
    void addUser(User user);
    void updateUserById(int id,User User);
    List<User> getAllUsers();
    User getUserById(int id);
    void removeUser(int id);


}
