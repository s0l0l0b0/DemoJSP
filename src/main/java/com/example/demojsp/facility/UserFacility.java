package com.example.demojsp.facility;

import com.example.demojsp.domain.User;
import com.example.demojsp.model.UserDTO;
import com.example.demojsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserFacility {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

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
}
