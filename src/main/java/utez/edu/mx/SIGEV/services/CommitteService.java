package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Color;
import utez.edu.mx.SIGEV.entity.Committee;
import utez.edu.mx.SIGEV.repository.ICommitteRepository;

import java.util.List;

@Service
public class CommitteService {
    @Autowired
    private ICommitteRepository committeRepository;

    public List<Committee> findAll() {
        return committeRepository.findAll();
    }

    public Committee findById(long id) {
        return committeRepository.getById(id);
    }


    public boolean exists(long id) {
        return committeRepository.findById(id) == null ? false : true;
    }

    public Page<Committee> listPagination(PageRequest page) {
        return committeRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(Committee obj) {
        boolean flag = false;
        Committee tmp = committeRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Committee tmp = committeRepository.getById(id);
        if (!tmp.equals(null)) {
            committeRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }

}
