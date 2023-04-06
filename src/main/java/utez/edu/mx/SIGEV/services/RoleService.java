package utez.edu.mx.SIGEV.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Person;
import utez.edu.mx.SIGEV.entity.Role;
import utez.edu.mx.SIGEV.repository.IRoleRepository;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private IRoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(long id) {
        return roleRepository.getById(id);
    }


    public boolean exists(long id) {
        return roleRepository.findById(id) == null ? false : true;
    }

    public Page<Role> listPagination(PageRequest page) {
        return roleRepository.findAll((org.springframework.data.domain.Pageable) page);
    }

    public boolean save(Role obj) {
        boolean flag = false;
        Role tmp = roleRepository.save(obj);
        if (!tmp.equals(null)) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id) {
        boolean flag = false;
        Role tmp = roleRepository.getById(id);
        if (!tmp.equals(null)) {
            roleRepository.delete(tmp);
            flag = true;
        }
        return flag;
    }
}
