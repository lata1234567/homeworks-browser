package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.StudentNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.StudentRole;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.RoleRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.StudentRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.RoleEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.StudentEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper.StudentMapper;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.StudentModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class StudentService {

    private static final Logger LOGGER = Logger.getLogger(StudentService.class.getName());

    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final StudentMapper studentMapper;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository, RoleRepository roleRepository,
                          StudentMapper studentMapper, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.studentMapper = studentMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<StudentModel> list() {
        LOGGER.info("list()");
        List<StudentEntity> entities = studentRepository.findAll();

        return studentMapper.fromEntities(entities);
    }

    public StudentModel create(StudentModel studentModel) {
        LOGGER.info("create(" + studentModel + ")");

        studentModel.setPassword(passwordEncoder.encode(studentModel.getPassword()));
        StudentEntity mappedEntity = studentMapper.from(studentModel);

        RoleEntity studentRoleEntity = roleRepository.findByName(StudentRole.USER.getName());
        mappedEntity.getRoles().add(studentRoleEntity);

        StudentEntity savedStudentEntity = studentRepository.save(mappedEntity);

        StudentModel mappedStudentModel = studentMapper.from(savedStudentEntity);
        
        LOGGER.info("create(...) = " + mappedStudentModel);
        return mappedStudentModel;
    }

    public StudentModel read(Long id) throws StudentNotFoundException {
        LOGGER.info("read(" + id + ")");

        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        StudentEntity studentEntity = optionalStudentEntity.orElseThrow(
                () -> new StudentNotFoundException("Not found student with id " + id));
        StudentModel studentModel = studentMapper.from(studentEntity);
        LOGGER.info("optionalStudentEntity " + optionalStudentEntity);

        return studentModel;
    }

    public StudentModel update(StudentModel studentModel) {
        LOGGER.info("update(" + studentModel + ")");

        StudentEntity mappedStudentEntity = studentMapper.from(studentModel);
        StudentEntity updateStudentEntity = studentRepository.save(mappedStudentEntity);

        return studentMapper.from(updateStudentEntity);
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        studentRepository.deleteById(id);
    }

    public List<StudentModel> search(String surname) {
        LOGGER.info("search("+surname+")");

        List<StudentEntity> studentEntities = studentRepository.findBySurname(surname);

        return studentMapper.fromEntities(studentEntities);
    }
}
