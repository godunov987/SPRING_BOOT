package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;



@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public User updateUserById(int id , User user) {
        em.merge(user);
        return user;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        em.remove(getUserById(id));
    }
}
