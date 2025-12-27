package edu.cjc.sms.app.service;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentServicei {

	public void saveStudentDetails(Student st);

	public List<Student> getAllData();

	public void deleteData(int id);

	public boolean isexistByEmail(String studentEmail);

	public List<Student> searchByBatchMode(String batchMode);
}
