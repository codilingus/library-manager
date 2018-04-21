package pl.codilingus.library.repositories;

import pl.codilingus.library.User;

import java.util.List;

public interface UserRepository {

    void addUser(User user);

    void deleteUser(int id);

    void editUser(int id , User user);

    int findUserById(int id);

    List<User> getAllUsers();
}
