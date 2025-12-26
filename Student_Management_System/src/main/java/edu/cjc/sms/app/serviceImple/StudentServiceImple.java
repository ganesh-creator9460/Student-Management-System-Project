package edu.cjc.sms.app.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repository.StudentRepository;
import edu.cjc.sms.app.service.StudentServicei;

@Service
public class StudentServiceImple implements StudentServicei {

	@Autowired
	StudentRepository sr;
	
	public void saveStudentDetails(Student st)
	{
		sr.save(st);
	}
}
