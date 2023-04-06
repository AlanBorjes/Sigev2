package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
}
