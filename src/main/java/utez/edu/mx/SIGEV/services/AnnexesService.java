package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Annexes;
import utez.edu.mx.SIGEV.entity.Committee;
import utez.edu.mx.SIGEV.repository.IAnnexesRepository;

import java.util.List;

@Service
public class AnnexesService {

    @Autowired
    private IAnnexesRepository annexesRepository;

    public List<Annexes> findAll() {
        return annexesRepository.findAll();
    }

    public Annexes findById(long id) {
        return annexesRepository.getById(id);
    }


    public boolean exists(long id) {
        return annexesRepository.findById(id) == null ? false : true;
    }

    public Page<Annexes> listPagination(PageRequest page) {
        return annexesRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(Annexes obj) {
        boolean flag = false;
        Annexes tmp = annexesRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Annexes tmp = annexesRepository.getById(id);
        if (!tmp.equals(null)) {
            annexesRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
