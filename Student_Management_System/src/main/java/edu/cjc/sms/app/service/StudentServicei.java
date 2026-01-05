package edu.cjc.sms.app.service;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentServicei {

	public void saveStudentDetails(Student st);

	public List<Student> getAllData();

	public void deleteData(int id);

	public boolean isexistByEmail(String studentEmail);

	public List<Student> searchByBatchMode(String batchMode);

	public List<Student> addPaging(int pageno, int pagesize);

	public Student getSingleStudent(int id);

	public List<Student> searchByBatchModeAndBatchNumber(String batchMode, String batchNumber);

	public void payFees(int studentID, double amount);

	public void shiftBatch(int studentID, String batchMode);
	
}
