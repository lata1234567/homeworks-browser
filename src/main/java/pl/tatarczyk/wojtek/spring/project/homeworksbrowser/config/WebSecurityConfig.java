package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
                                .antMatchers("/homeworks/create").hasRole("USER")
                                .antMatchers(HttpMethod.POST, "/students").permitAll()
                                .antMatchers(HttpMethod.GET, "/students/create").permitAll()
                                .antMatchers("/students/create/success").permitAll()
//                                .antMatchers("/homeworks/create").denyAll()
                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form.permitAll())
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password123")
                        .roles("USER")
//                        .roles("USER","ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}

