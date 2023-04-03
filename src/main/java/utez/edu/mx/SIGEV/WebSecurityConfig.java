package utez.edu.mx.SIGEV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import utez.edu.mx.SIGEV.handler.CustomLoginSuccessHandler;
import utez.edu.mx.SIGEV.handler.CustomLogoutSuccessHandler;
import utez.edu.mx.SIGEV.services.JpaUserDetailService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private final JpaUserDetailService detailService;
    
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private final CustomLoginSuccessHandler successHandler;

    private final CustomLogoutSuccessHandler customLogoutSuccessHandler;

    public WebSecurityConfig(JpaUserDetailService detailService, BCryptPasswordEncoder bCryptPasswordEncoder, CustomLoginSuccessHandler successHandler, CustomLogoutSuccessHandler customLogoutSuccessHandler) {
        this.detailService = detailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.successHandler = successHandler;
        this.customLogoutSuccessHandler = customLogoutSuccessHandler;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(detailService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**","/img/**", "/sing")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .successHandler(successHandler)
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessHandler(customLogoutSuccessHandler)
                    .permitAll()
                .and()
                    .exceptionHandling().accessDeniedPage("/error_403");
    }
}

