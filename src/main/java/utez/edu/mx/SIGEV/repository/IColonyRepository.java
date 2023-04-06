package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.Colony;

public interface IColonyRepository extends JpaRepository<Colony, Long> {
    public Colony findById(long id);


}
