package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.Person;

public interface IPersonInterface extends JpaRepository<Person, Long> {
}
