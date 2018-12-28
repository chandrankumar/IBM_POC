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
import com.ibm.vo.DepartmentVO;
import com.ibm.vo.ParentVO;
import com.ibm.vo.RegistrationVO;
import com.ibm.vo.StudentVO;

@Controller
@RequestMapping(value = "/ibm")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/home")
    public String home() {
	return "index";
    }

    /**
     * @param studentVO
     * @return
     */
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public @ResponseBody String saveStudentDetails(@RequestBody StudentVO studentVO) {

	System.out.println(studentVO);

	Integer studentId = studentService.saveStudentDetail(studentVO);
	return StudentConstant.STUD_MSG + studentId;

    }

    /**
     * @return
     */
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public @ResponseBody List<StudentVO> retrieveDetails() {

	return studentService.retrieveStudentDetails();

    }

    /**
     * @param parentVO
     * @return
     */
    @RequestMapping(value = "/parent", method = RequestMethod.POST)
    public @ResponseBody String saveParentsDetails(@RequestBody ParentVO parentVO) {

	Integer parentId = studentService.saveParentsDetails(parentVO);
	return StudentConstant.PARENT_MSG + parentId;

    }

    /**
     * @return
     */
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public @ResponseBody List<DepartmentVO> retrieveDepartmentDetails() {

	return studentService.retrieveDepartmentDetails();

    }

    /**
     * @param parentVO
     * @return
     */
    @RequestMapping(value = "/mapped", method = RequestMethod.POST)
    public @ResponseBody String mapStudentRegistration(@RequestBody RegistrationVO registrationVO) {

	Integer studentId = studentService.mapStudentRegistration(registrationVO);
	return StudentConstant.MAPPED_STUD_MSG + studentId;

    }

}
