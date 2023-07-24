package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.StudentRole;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
//                        .antMatchers("/", "/home").permitAll()
//                        .antMatchers("/**").permitAll()
                                .antMatchers("/homeworks/create").hasAnyRole(
                                        StudentRole.USER.getName(),
                                        StudentRole.ADMIN.getName())
                                .antMatchers(HttpMethod.POST, "/students").permitAll()
                                .antMatchers(HttpMethod.GET, "/students/create").permitAll()
                                .antMatchers("/students/create/success").permitAll()
                                .antMatchers("/h2-console/**").permitAll()
//                                .antMatchers("/homeworks/create").denyAll()
                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form.permitAll())
                .logout((logout) -> logout.permitAll());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("user")
////                        .password("password123")
////                        .roles("USER")
//////                        .roles("USER","ADMIN")
////                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new HomeworksUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

