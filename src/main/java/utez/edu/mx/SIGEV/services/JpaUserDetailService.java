package utez.edu.mx.SIGEV.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utez.edu.mx.SIGEV.entity.Role;
import utez.edu.mx.SIGEV.entity.UserComite;
import utez.edu.mx.SIGEV.reposity.UserComiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaUserDetailService implements UserDetailsService {

    private final UserComiteRepository UserComiteRepository;

    public JpaUserDetailService(UserComiteRepository UserComiteRepository) {
        this.UserComiteRepository = UserComiteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserComite user = UserComiteRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("No se ha encontrado información sobre el usuario ".concat(username));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role rol: user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        }


        if (authorities.isEmpty()) {
            throw new UsernameNotFoundException("El usuario " + username + " no tiene un rol asignado");
        }

        return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
    }
}