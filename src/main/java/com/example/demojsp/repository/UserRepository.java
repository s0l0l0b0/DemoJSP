package com.example.demojsp.repository;

import com.example.demojsp.domain.User;
import com.example.demojsp.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.example.demojsp.model.UserDTO(u.name, u.age) FROM User u where u.id=?1")
    UserDTO getDtoById(Long id);

    @Query("SELECT sum(user.age) as sumAge FROM User user WHERE sumAge > 100")
    Long getUser();
}
