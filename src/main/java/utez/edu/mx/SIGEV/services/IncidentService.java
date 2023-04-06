package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.ContentApp;
import utez.edu.mx.SIGEV.entity.Incident;
import utez.edu.mx.SIGEV.repository.IIncidentRepository;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IIncidentRepository IncidentRepository;

    public List<Incident> findAll() {
        return IncidentRepository.findAll();
    }

    public Incident findById(long id) {
        return IncidentRepository.getById(id);
    }


    public boolean exists(long id) {
        return IncidentRepository.findById(id) == null ? false : true;
    }

    public Page<Incident> listPagination(PageRequest page) {
        return IncidentRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(Incident obj) {
        boolean flag = false;
        Incident tmp = IncidentRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Incident tmp = IncidentRepository.getById(id);
        if (!tmp.equals(null)) {
            IncidentRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
