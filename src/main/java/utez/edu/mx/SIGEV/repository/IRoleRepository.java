package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
