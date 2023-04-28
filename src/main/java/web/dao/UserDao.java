package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    List<User> getAllUsers();
    void removeUser(User user);
    void editUser(User user);
    void getUser(User user);
}
