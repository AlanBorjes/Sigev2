package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import utez.edu.mx.SIGEV.entity.SessionControlAccess;

@Repository
public interface SessionControlAccessRepository extends JpaRepository<SessionControlAccess, Long> {
    @Query("SELECT s FROM SessionControlAccess s WHERE s.username LIKE ?1 AND s.isActualSession = true")
    SessionControlAccess findActualSessionByUsername(String username);
}
