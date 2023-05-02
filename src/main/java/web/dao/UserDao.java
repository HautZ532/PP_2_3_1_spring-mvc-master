package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    List<User> getAllUsers();
    void removeUser(long id);
    void editUser(User user);
    User getUser(long id);
}
