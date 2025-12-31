package edu.cjc.sms.app.serviceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Override
	public List<Student> addPaging(int pageno, int pagesize) {
		
		Pageable of = PageRequest.of(pageno, pagesize);
		
		List<Student>list = sr.findAll(of).getContent();
		return list;
	}

	@Override
	public Student getSingleStudent(int id) {
		
		Optional<Student> op = sr.findById(id);
		Student stu = op.get();
		return stu;
	}

	@Override
	public List<Student> searchByBatchModeAndBatchNumber(String batchMode, String batchNumber) {
		
		List<Student> student = sr.findAllByBatchModeAndBatchNumber(batchMode,batchNumber);
		return student;
	}

	@Override
	public void payFees(int studentID, double amount) {
		
		Optional<Student> op = sr.findById(studentID);
		if(op.isPresent())
		{
			Student stu = op.get();
			stu.setFeesPaid(stu.getFeesPaid()+amount);
			sr.save(stu);
		}
		else
		{
			throw new ArithmeticException("Data is not Found");
		}
	}
	
}
