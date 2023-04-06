package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Colony;
import utez.edu.mx.SIGEV.repository.IColonyRepository;

import java.util.List;

@Service
public class ColonyService {

    @Autowired
    private IColonyRepository colonyRepository;

    public List<Colony> findAll() {
        return colonyRepository.findAll();
    }

    public Colony findByUserId(long id) {
        return colonyRepository.findById(id);
    }


    public Colony findOne(long id) {
        return colonyRepository.getById(id);
    }

    public boolean save(Colony obj) {
        boolean flag = false;
        Colony tmp = colonyRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Colony tmp = colonyRepository.getById(id);
        if (!tmp.equals(null)) {
            colonyRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
