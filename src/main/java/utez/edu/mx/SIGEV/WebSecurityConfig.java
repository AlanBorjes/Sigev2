package utez.edu.mx.SIGEV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        //configura paths publicos
        http.authorizeHttpRequests(
                //request autorizados
                (requests) -> {
                    requests.requestMatchers(  "/css/**", "/js/**", "/img/**", "/error/**", "/images/**", "imagenes/**", "/docs/**").permitAll();
                    requests.requestMatchers("/sign").permitAll();
                    requests.anyRequest().authenticated();
                }
        );
        //configurar pagina de login

        http.formLogin(
                (login) -> {
                    login.loginPage("/index").permitAll();
                }
        );

        http.logout(
                (logout) -> {
                    logout.permitAll();
                }
        );
        http.exceptionHandling().accessDeniedPage("/error_403");
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("rodo@gmail.com")
                .password("12345")
                .roles("admin")
                .build();
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("fabi")
                .password("6789")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(user, user1);
    }
}
