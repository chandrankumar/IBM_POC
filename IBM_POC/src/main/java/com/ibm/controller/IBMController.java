package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.constant.StudentConstant;
import com.ibm.service.StudentService;
import com.ibm.vo.StudentVO;

@Controller
@RequestMapping(value="/ibm")
public class IBMController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	
	@RequestMapping(value="/student" , method = RequestMethod.GET)
	public @ResponseBody List<StudentVO> retrieveDetails(){
		
		return studentService.retrieveStudentDetails();
		
	}
	
	@RequestMapping(value="/student" , method = RequestMethod.POST)
	public @ResponseBody String saveDetails(@RequestBody StudentVO studentVO){
		
		System.out.println(studentVO);
		
		Integer studentId = studentService.saveStudentDetail(studentVO);
		return StudentConstant.MSG +studentId;
		
	}
}
