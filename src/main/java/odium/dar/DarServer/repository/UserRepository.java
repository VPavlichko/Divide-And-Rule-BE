package odium.dar.DarServer.repository;

import odium.dar.DarServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserById(Long id);
    Optional<User> findUserByEmail(String email);
    Optional<User> findByUsername(String email);
    Optional<User> findUserById(Long id);
}
