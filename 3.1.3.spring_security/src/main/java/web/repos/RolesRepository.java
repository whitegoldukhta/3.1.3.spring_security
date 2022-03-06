package web.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {
}
