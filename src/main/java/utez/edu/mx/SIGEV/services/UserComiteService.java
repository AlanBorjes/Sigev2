package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.repository.UserComiteRepository;

@Service
public class UserComiteService {

    @Autowired
    private UserComiteRepository userComiteRepository;

}
