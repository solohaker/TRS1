package com.tmzla.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tmzla.training.model.Course;
import com.tmzla.training.model.Student;
import com.tmzla.training.service.ICourseService;
import com.tmzla.training.service.IStudentService;


@Controller
public class StudentController {
	
	@Autowired
	IStudentService studentService;
	@Autowired
	ICourseService courseService;
	
	
	
	
	@RequestMapping(value="/students/list", method=RequestMethod.GET)
	public ModelAndView students() {
		ModelAndView mav=new ModelAndView();
		List<Student> students=studentService.findAll();
		mav.addObject("students", students);
		mav.setViewName("/student/list");
		return mav;
	}
	
	
	@RequestMapping(value="/students/delete/{id}", method=RequestMethod.GET)
	public String deleteAStudentRecord(Model model,@PathVariable("id") Long id) {
		studentService.delete(id);
	
		return "redirect:/students/list";
		
	}
	
	
	@RequestMapping(value="/students/new", method=RequestMethod.GET)
	public String studentRegistrationForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/new";
		
	}
	
	@RequestMapping(value="/students/new", method=RequestMethod.POST)
	public String registerNewStudent( @Valid @ModelAttribute("student") Student student
			, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "student/new";
		}
		student=studentService.save(student);
		return "redirect:/students/list";
		
	}
	
	@RequestMapping(value="/students/edit/{id}", method=RequestMethod.GET)
	public String editStudentForm(Model model,@PathVariable("id") Long id) {
		Student student=studentService.findById(id);
		model.addAttribute("student",  student);
		List<Course> courses=courseService.findAll();
		model.addAttribute("courses",courses);
		return "student/edit";
		
	}
	
	
	@RequestMapping(value="/students/edit", method=RequestMethod.POST)
	public String editAStudentRecord( @Valid @ModelAttribute("student") Student student
			, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "student/edit";
		}
		student=studentService.save(student);
		return "redirect:/students/list";	
	}
	
	
	
	/*
	
	@RequestMapping(value="/students/new", method=RequestMethod.GET)
	public String studentRegistrationForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/new";
		
	}
	
	@RequestMapping(value="/students/new", method=RequestMethod.POST)
	public String registerNewStudent( @Valid @ModelAttribute("student") Student student
			, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "student/new";
		}
		student=studentService.save(student);
		return "redirect:/students/list";
		
	}
	
	@RequestMapping(value="/students/edit/{id}", method=RequestMethod.GET)
	public String editStudentForm(Model model,@PathVariable("id") Long id) {
		Student student=studentService.findById(id);
		model.addAttribute("student",  student);
		return "student/edit";
		
	}
	
	
	@RequestMapping(value="/students/edit", method=RequestMethod.POST)
	public String editAStudentRecord( @Valid @ModelAttribute("student") Student student
			, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "student/edit";
		}
		student=studentService.save(student);
		return "redirect:/students/list";	
	}
	
	@RequestMapping(value="/students/delete/{id}", method=RequestMethod.GET)
	public String deleteAStudentRecord(Model model,@PathVariable("id") Long id) {
		studentService.delete(id);
	
		return "redirect:/students/list";
		
	}
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	/*
	 * //For opening Add Course form
	@RequestMapping(value = "addStudentCourse/{id}", method = RequestMethod.GET)
	public String addCourse(@PathVariable("id") Long studentId, Model model){
	    model.addAttribute("courses", crepository.findAll());
		model.addAttribute("student", repository.findOne(studentId));
	    return "addStudentCourse";
	}*/

	
	/*
	
	  //For saving added course

@RequestMapping(value="/student/{id}/courses", method=RequestMethod.GET)
public String studentsAddCourse(@PathVariable Long id,
 @RequestParam Long courseId, Model model) {
	Course course = crepository.findOne(courseId);
	Student student = repository.findOne(id);

	if (student != null) {
		if (!student.hasCourse(course)) {
			student.getCourses().add(course);
		}
		repository.save(student);
		model.addAttribute("student", crepository.findOne(id));
		model.addAttribute("courses", crepository.findAll());
		return "redirect:/students";
	}
	return "redirect:/students";
}
	 */
}
