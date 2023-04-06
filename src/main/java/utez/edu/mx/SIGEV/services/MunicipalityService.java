package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Incident;
import utez.edu.mx.SIGEV.entity.Municipality;
import utez.edu.mx.SIGEV.repository.MunicipalityRepository;

import java.util.List;

@Service
public class MunicipalityService {

    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<Municipality> findAll() {
        return municipalityRepository.findAll();
    }

    public Municipality findById(long id) {
        return municipalityRepository.getById(id);
    }


    public boolean exists(long id) {
        return municipalityRepository.findById(id) == null ? false : true;
    }

    public Page<Municipality> listPagination(PageRequest page) {
        return municipalityRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(Municipality obj) {
        boolean flag = false;
        Municipality tmp = municipalityRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Municipality tmp = municipalityRepository.getById(id);
        if (!tmp.equals(null)) {
            municipalityRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
