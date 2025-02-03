package file.service;

import java.util.List;

import org.springframework.stereotype.Service;

import file.entity.Student;
import file.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {

	private final StudentRepository studentRepository;
	
	public Student insertStudent (Student student) {
		return studentRepository.save(student);
	}

	public List<Student> selectStudentAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	public Student selectStudent (Long id) {
		return studentRepository.findById(id).get();
	}
	
	public void updateStudent (Long id, Student student) {
		Student std = studentRepository.getReferenceById(id);
		
		if(std != null) {
			student.setId(id);
			studentRepository.save(student);	
		}
	}
	
	public void deleteStudent (Long id) {
		studentRepository.deleteById(id);
	}
}
