package odium.dar.DarServer.repository;

import odium.dar.DarServer.model.Role;
import odium.dar.DarServer.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole role);

}
