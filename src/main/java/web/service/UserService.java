package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getAllUsers();
    void removeUser(long id);
    User editUser(User user);
    User getUser(long id);
}
