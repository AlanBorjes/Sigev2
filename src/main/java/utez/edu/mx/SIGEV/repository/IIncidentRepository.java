package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.Incident;

public interface IIncidentRepository  extends JpaRepository<Incident, Long> {
}
