package utez.edu.mx.SIGEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.SIGEV.entity.Category;

public interface ICategory extends JpaRepository<Category, Long> {
    public Category findBydescription(String name);
}
