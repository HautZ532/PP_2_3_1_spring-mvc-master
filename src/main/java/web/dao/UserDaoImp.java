package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public void getUser(User user) {
        entityManager.createQuery("from User where User.id = :id", User.class);
    }


}
