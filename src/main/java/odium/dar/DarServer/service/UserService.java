package odium.dar.DarServer.service;

import odium.dar.DarServer.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User addUser(User user);

    User updateUser(User user);

    void deleteUSer(Long id);

    User findUserById(Long id);
}
