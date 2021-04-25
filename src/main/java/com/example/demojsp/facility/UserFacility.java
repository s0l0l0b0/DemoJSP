package com.example.demojsp.facility;

import com.example.demojsp.domain.User;
import com.example.demojsp.model.UserDTO;
import com.example.demojsp.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserFacility {

    private static final Logger logger = LoggerFactory.getLogger(UserFacility.class);
    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    private final SessionFactory sessionFactory;

    @Autowired
    public UserFacility(EntityManagerFactory entityManagerFactory) {
        final SessionFactory factory = entityManagerFactory.unwrap(SessionFactory.class);
        if (Objects.nonNull(factory)) {
            this.sessionFactory = factory;
        } else {
            throw new NullPointerException("Unable to get a hold of SessionFactory instance");
        }
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public Optional<User> get(Long userId) {
       return userRepository.findById(userId);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        userRepository.save(user);
    }

    public UserDTO getUserDto(Long id) {
        if (Objects.nonNull(id)) {
            return userRepository.getDtoById(id);
        }
        return null;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    // if u update a object inside this transactional method then u don't have to
    // call save method. transaction will automatically get committed
    @Transactional
    public void addOneYear(Long userId) {
        final User user = getEntityManager().find(User.class, userId);
        user.setAge(user.getAge() + 1);
    }

    @Transactional
    public User getOneWithEntityManager(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Transactional
    public void modify() {
        final User user = getEntityManager()
                .createQuery("SELECT u from User u where u.id=:id", User.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println("user: " + user);
        user.setAge(54);
//        user.setId(null);
        System.out.println("modified user details: " + user);
//        save(user);
//        User user = null;
//        try (Session currentSession = sessionFactory.getCurrentSession()) {
//            Transaction transaction = currentSession.beginTransaction();
//            user = currentSession.find(User.class, 1L);
//            user.setAge(543);
//            transaction.commit();
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
    }
}
