package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Category;
import utez.edu.mx.SIGEV.repository.ICategory;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ICategory categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(long id) {
        return categoryRepository.getById(id);
    }

    public Category findByName(String name) {
        return categoryRepository.findBydescription(name);
    }

    public boolean exists(String name) {
        return categoryRepository.findBydescription(name) == null ? false : true;
    }

    public Page<Category> listPagination(PageRequest page) {
        return categoryRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(Category obj) {
        boolean flag = false;
        Category tmp = categoryRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Category tmp = categoryRepository.getById(id);
        if (!tmp.equals(null)) {
            categoryRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
