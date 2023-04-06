package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Municipality;
import utez.edu.mx.SIGEV.entity.Person;
import utez.edu.mx.SIGEV.repository.IPersonInterface;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private IPersonInterface personInterface;

    public List<Person> findAll() {
        return personInterface.findAll();
    }

    public Person findById(long id) {
        return personInterface.getById(id);
    }


    public boolean exists(long id) {
        return personInterface.findById(id) == null ? false : true;
    }

    public Page<Person> listPagination(PageRequest page) {
        return personInterface.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(Person obj) {
        boolean flag = false;
        Person tmp = personInterface.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Person tmp = personInterface.getById(id);
        if (!tmp.equals(null)) {
            personInterface.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
