package pl.codilingus.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.codilingus.library.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;

@Component
public class DbUserRepository implements UserRepository {
    private EntityManager entityManager;

    @Autowired
    public DbUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(id);
    }

    @Override
    public User editUser(User user , int id) {
        user.setId(id);
        return entityManager.merge(user);
    }

    @Override
    public User findUserById(int id) {
        User user = entityManager.find(User.class , id);
        if (user == null){
            throw new EntityNotFoundException("Can't find User for ID "
                    + id);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("SELECT * FROM user");
        return (List<User>)query.getResultList();
    }
}
