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
		if (username.equals("admin") && password.equals("admin123")) {
			List<Student> list = ssi.getAllData();
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

			List<Student> list = ssi.getAllData();
			m.addAttribute("data", list);
			m.addAttribute("error", studentEmail + " is already exist");
			return "adminscreen";
		} else {
			ssi.saveStudentDetails(student);
			List<Student> list = ssi.getAllData();
			m.addAttribute("data", list);
			return "adminscreen";
		}
	}

	@RequestMapping("/delete")
	public String deleteData(@RequestParam("id") int id, Model m) {

		ssi.deleteData(id);
		List<Student> list = ssi.getAllData();
		m.addAttribute("data", list);
		return "adminscreen";
	}

	@RequestMapping("/search")
	public String getDataBatchMode(@RequestParam("batchMode") String batchMode, Model m) {
		List<Student> result = ssi.searchByBatchMode(batchMode);

		if (result.size() > 0) {
			m.addAttribute("data", result);

		} 
		if(batchMode.equals("All"))
		{
			List<Student> list = ssi.getAllData();
			m.addAttribute("data", list);
		}
		
//		else {
//			m.addAttribute("message", "Not found " + batchMode);
//			List<Student> list = ssi.getAllData();
//			m.addAttribute("data", list);
//		}
		return "adminscreen";
	}

}
