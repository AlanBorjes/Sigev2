package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Color;
import utez.edu.mx.SIGEV.entity.ContentApp;
import utez.edu.mx.SIGEV.repository.IContentAppRepository;

import java.util.List;

@Service
public class ContentAppService {

    @Autowired
    private IContentAppRepository contentAppRepository;

    public List<ContentApp> findAll() {
        return contentAppRepository.findAll();
    }

    public ContentApp findById(long id) {
        return contentAppRepository.getById(id);
    }


    public boolean exists(long id) {
        return contentAppRepository.findById(id) == null ? false : true;
    }

    public Page<ContentApp> listPagination(PageRequest page) {
        return contentAppRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(ContentApp obj) {
        boolean flag = false;
        ContentApp tmp = contentAppRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        ContentApp tmp = contentAppRepository.getById(id);
        if (!tmp.equals(null)) {
            contentAppRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }

}
