package edu.cjc.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.service.StudentServicei;

@Controller
public class AdminController {

	@Autowired
	StudentServicei ssi;

	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String onLogin(@RequestParam String username, @RequestParam String password, Model m) {
		if (username.equals("admin") && password.equals("admin")) {
			
			int pageno = 0;
			int pagesize = 10;
			List<Student> list = ssi.addPaging(pageno, pagesize);
			m.addAttribute("data", list);
			return "adminscreen";
		} else {
			m.addAttribute("login_fail", "Enter valid Login Details");
			return "login";
		}
	}

	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student student, @RequestParam("studentEmail") String studentEmail,
			Model m) {

		boolean isexist = ssi.isexistByEmail(studentEmail);
		
		if (isexist) {
			int pageno = 0;
			int pagesize = 10;
			List<Student> list = ssi.addPaging(pageno, pagesize);
			m.addAttribute("data", list);
			m.addAttribute("error", studentEmail + " is already exist");
			return "adminscreen";
		} else {
			ssi.saveStudentDetails(student);
			int pageno = 0;
			int pagesize = 10;
			List<Student> list = ssi.addPaging(pageno, pagesize);
			m.addAttribute("success","Student Enroll Successfully");
			m.addAttribute("data", list);
			return "adminscreen";
		}
	}

	@RequestMapping("/delete")
	public String deleteData(@RequestParam("id") int id, Model m) {

		ssi.deleteData(id);
		int pageno = 0;
		int pagesize = 10;
		List<Student> list = ssi.addPaging(pageno, pagesize);
		m.addAttribute("data", list);
		return "adminscreen";
	}

	@RequestMapping("/search")
	public String getDataBatchMode(@RequestParam("batchMode") String batchMode,
			@RequestParam("batchNumber") String batchNumber, Model m) {
		List<Student> result = ssi.searchByBatchModeAndBatchNumber(batchMode, batchNumber);

		if (result.size() > 0) {
			m.addAttribute("data", result);
		} else {
			m.addAttribute("message", "Not found " + batchNumber + " " + batchMode);
			int pageno = 0;
			int pagesize = 10;
			List<Student> list = ssi.addPaging(pageno, pagesize);
			m.addAttribute("data", list);
		}
		return "adminscreen";
	}

	@RequestMapping("/paging")
	public String paging(int pageno, Model m) {
		int pagesize = 10;
		List<Student> list = ssi.addPaging(pageno, pagesize);
		m.addAttribute("data", list);
		return "adminscreen";
	}

	@RequestMapping("/pay")
	public String onfees(@RequestParam("id") int id, Model m) {

		Student stu = ssi.getSingleStudent(id);
		m.addAttribute("stu", stu);
		return "fees";
	}

	@RequestMapping("/payfees")
	public String payfees(@RequestParam("studentID") int studentID, @RequestParam("amount") double amount, Model m) {
		ssi.payFees(studentID, amount);
		int pageno = 0;
		int pagesize = 10;
		List<Student> list = ssi.addPaging(pageno, pagesize);
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int studentID,Model m)
	{
		Student stu = ssi.getSingleStudent(studentID);
		m.addAttribute("stu",stu);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String updated(@ModelAttribute Student s,Model m)
	{
		ssi.saveStudentDetails(s);
		int pageno = 0;
		int pagesize = 10;
		List<Student> list = ssi.addPaging(pageno, pagesize);
		m.addAttribute("data", list);
		return "adminscreen";
	}

	@RequestMapping("/shift")
	public String shift(@RequestParam("id") int id,Model m)
	{
		Student stu = ssi.getSingleStudent(id);
		m.addAttribute("stu", stu);
		return "shift";
	}
	
	@RequestMapping("/shifted")
	public String shifted(@RequestParam("studentID") int studentID,@RequestParam("batchMode") String batchMode,@RequestParam("batchNumber") String batchNumber,Model m)
	{
		ssi.shiftBatch(studentID,batchMode,batchNumber);
		int pageno = 0;
		int pagesize = 10;
		List<Student> list = ssi.addPaging(pageno, pagesize);
		m.addAttribute("data", list);
		return "adminscreen";
	}
}
