package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.State_Incident;

public interface IStatesIncident extends JpaRepository<State_Incident, Long> {
}
