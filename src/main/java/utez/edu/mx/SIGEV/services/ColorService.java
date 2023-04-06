package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Category;
import utez.edu.mx.SIGEV.entity.Color;
import utez.edu.mx.SIGEV.repository.IColorRepository;

import java.util.List;

@Service
public class ColorService {

    @Autowired
    private IColorRepository colorRepository;

    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    public Color findById(long id) {
        return colorRepository.getById(id);
    }


    public boolean exists(long id) {
        return colorRepository.findById(id) == null ? false : true;
    }

    public Page<Color> listPagination(PageRequest page) {
        return colorRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(Color obj) {
        boolean flag = false;
        Color tmp = colorRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Color tmp = colorRepository.getById(id);
        if (!tmp.equals(null)) {
            colorRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
