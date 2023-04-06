package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Role;
import utez.edu.mx.SIGEV.entity.State_Incident;
import utez.edu.mx.SIGEV.repository.IStatesIncident;

import java.util.List;

@Service
public class StateIncidentService {

    @Autowired
    private IStatesIncident statesIncident;

    public List<State_Incident> findAll() {
        return statesIncident.findAll();
    }

    public State_Incident findById(long id) {
        return statesIncident.getById(id);
    }


    public boolean exists(long id) {
        return statesIncident.findById(id) == null ? false : true;
    }

    public Page<State_Incident> listPagination(PageRequest page) {
        return statesIncident.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(State_Incident obj) {
        boolean flag = false;
        State_Incident tmp = statesIncident.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        State_Incident tmp = statesIncident.getById(id);
        if (!tmp.equals(null)) {
            statesIncident.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
