package utez.edu.mx.SIGEV.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.SIGEV.entity.UserComite;

@Repository
public interface UserRepository extends JpaRepository<UserComite, Long> {

    UserComite findUserByUsername(String username);
}
