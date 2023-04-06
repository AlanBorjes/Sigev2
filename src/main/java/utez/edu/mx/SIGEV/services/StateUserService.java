package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.State_Incident;
import utez.edu.mx.SIGEV.entity.State_User;
import utez.edu.mx.SIGEV.repository.StateUserRepository;

import java.util.List;

@Service
public class StateUserService {

    @Autowired
    private StateUserRepository stateUserRepository;

    public List<State_User> findAll() {
        return stateUserRepository.findAll();
    }

    public State_User findById(long id) {
        return stateUserRepository.getById(id);
    }


    public boolean exists(long id) {
        return stateUserRepository.findById(id) == null ? false : true;
    }

    public Page<State_User> listPagination(PageRequest page) {
        return stateUserRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(State_User obj) {
        boolean flag = false;
        State_User tmp = stateUserRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        State_User tmp = stateUserRepository.getById(id);
        if (!tmp.equals(null)) {
            stateUserRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
