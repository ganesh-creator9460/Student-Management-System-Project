package edu.cjc.sms.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.sms.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	boolean existsByStudentEmail(String studentEmail);
	
	public List<Student> findAllByBatchMode(String batchMode);

	public List<Student> findAllByBatchModeAndBatchNumber(String batchMode, String batchNumber);
	
}
