package edu.cjc.sms.app.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repository.StudentRepository;
import edu.cjc.sms.app.service.StudentServicei;

@Service
public class StudentServiceImple implements StudentServicei {

	@Autowired
	StudentRepository sr;

	public void saveStudentDetails(Student st) {
		sr.save(st);

	}

	@Override
	public List<Student> getAllData() {

		List<Student> list = sr.findAll();
		return list;
	}

	@Override
	public void deleteData(int id) {

		sr.deleteById(id);

	}

	@Override
	public boolean isexistByEmail(String studentEmail) {
		
		boolean isexist = sr.existsByStudentEmail(studentEmail);
		return isexist;

	}

	@Override
	public List<Student> searchByBatchMode(String batchMode) {
		
		List<Student> list = sr.findAllByBatchMode(batchMode);
		
		return list;
	}
}
