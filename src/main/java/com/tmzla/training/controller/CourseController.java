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
import org.springframework.web.servlet.ModelAndView;

//import com.tmzla.training.model.Section;
import com.tmzla.training.service.ICourseService;
import com.tmzla.training.model.Course;


@Controller

public class CourseController {

	
@Autowired
private ICourseService courseService;
		
		@RequestMapping(value="/courses/list", method=RequestMethod.GET)
		public ModelAndView courses() {
			ModelAndView mav = new ModelAndView();
			List<Course> courses = courseService.findAll();
			mav.addObject("courses", courses);		
			mav.setViewName("course/list");
			return mav;
		}
		
		@RequestMapping(value="/courses/new", method = RequestMethod.GET)
		public String coursesRegistrationForm(Model model){			
			model.addAttribute("course", new Course());
			List<Course> courses = courseService.findAll();
			model.addAttribute("courses", courses);
			return "course/new";
		}
		
		@RequestMapping(value = "/courses/new", method = RequestMethod.POST)
		public String registerNewCourse(@Valid @ModelAttribute("course") Course course, 
				BindingResult bindingResult, Model model) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("errors", bindingResult.getAllErrors());
				return "course/new";
			}
			course = courseService.save(course);
			return "redirect:/courses/list";
		}
		
		
		@RequestMapping(value="/courses/edit/{id}", method = RequestMethod.GET)
	    public String editCourseForm(Model model, @PathVariable("id") Long id){         
		    Course course = courseService.findById(id);
	       model.addAttribute("course", course);
	        List<Course> courses = courseService.findAll();
	        model.addAttribute("courses", courses);
	        return "course/edit";
	    }
		
		@RequestMapping(value = "/courses/edit", method = RequestMethod.POST)
	    public String editCourseForm(@Valid @ModelAttribute("course") Course course, 
	            BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            return "course/edit";
	        }
	        course = courseService.save(course);
	        return "redirect:/courses/list";
	    }
		
		
		@RequestMapping(value="courses/delete/{id}", method = RequestMethod.GET)
	    public String deleteCourseForm(Model model, @PathVariable("id") Long id){         
	        courseService.delete(id);
	        return "redirect:/courses/list";
	    }
		
		/*
		@RequestMapping(value="/courses/new", method = RequestMethod.GET)
		public String coursesEditForm(Model model){			
			model.addAttribute("course", new Course());
			List<Course> courses = courseService.findAll();
			model.addAttribute("courses", courses);
			return "course/new";
		}
		
		@RequestMapping(value = "/courses/new", method = RequestMethod.POST)
		public String registerNewCourse(@Valid @ModelAttribute("course") Course course, 
				BindingResult bindingResult, Model model) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("errors", bindingResult.getAllErrors());
				return "course/new";
			}
			course = courseService.save(course);
			return "redirect:/courses/list";
		}
		
		@RequestMapping(value="/courses/edit/{id}", method = RequestMethod.GET)
	    public String editCourseForm(Model model, @PathVariable("id") Long id){         
		    Course course = courseService.findById(id);
	       model.addAttribute("course", course);
	        /*List<Course> courses = courseService.findAll();
	        model.addAttribute("courses", courses);
	        return "course/edit";
	    }
		
		@RequestMapping(value = "/courses/edit", method = RequestMethod.POST)
	    public String editCourseForm(@Valid @ModelAttribute("course") Course course, 
	            BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            return "course/edit";
	        }
	        course = courseService.save(course);
	        return "redirect:/courses/list";
	    }
		
		@RequestMapping(value="courses/delete/{id}", method = RequestMethod.GET)
	    public String deleteCourseForm(Model model, @PathVariable("id") Long id){         
	        courseService.delete(id);
	        return "redirect:/courses/list";
	    }
		
	
	*/
	
}
