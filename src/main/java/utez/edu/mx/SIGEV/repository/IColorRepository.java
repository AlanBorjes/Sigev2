package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.Color;

public interface IColorRepository extends JpaRepository<Color, Long> {
}
