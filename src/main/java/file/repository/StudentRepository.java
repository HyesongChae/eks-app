package file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import file.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
