package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.StudentRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.StudentEntity;

import java.util.logging.Logger;

@Service
public class HomeworksUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(HomeworksUserDetailsService.class.getName());

    @Autowired
    private StudentRepository studentRepository;

//    public HomeworksUserDetailsService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LOGGER.info("loadUserByUsername(" + username + ")");

        if (username == null) {
            throw new UsernameNotFoundException("unable to find user with name " + username);
        }

        StudentEntity studentEntity = studentRepository.findByLogin(username);
        UserDetails userDetails = User.withUsername(studentEntity.getLogin())
                .password(studentEntity.getPassword())
                .roles("USER")
                .build();

        LOGGER.info("loadUserByUsername(...) = " + userDetails);

        return userDetails;
    }
}
