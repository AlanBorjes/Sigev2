package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.ContentApp;

public interface IContentAppRepository extends JpaRepository<ContentApp, Long> {
}
