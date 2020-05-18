package com.tmzla.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmzla.training.service.IStudentService;



import com.tmzla.training.model.Student;

@RestController
@RequestMapping("/api")
public class RESTAPIController {
	@Autowired
	IStudentService studentService;
	
	@RequestMapping(value="/students/list",method=RequestMethod.GET)
	@ResponseBody
	public List<Student> findAll(){
		return studentService.findAll();
	}
	
	@GetMapping(value="/students/{id}")
	@ResponseBody
	public Student findStudentById(@PathVariable Long id) {
		return studentService.findById(id);
	}
	
	@PostMapping(value="/students/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student newStudent=studentService.save(student);
		return new ResponseEntity<Student> (newStudent, HttpStatus.CREATED);
	}
	
	
	  @DeleteMapping(value = "/students/delete/{id}")
	  @ResponseBody
	  public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
	    studentService.delete(id);
	    return new ResponseEntity<String>("Student Deleted Successfully! Product ID: " + id,
	        HttpStatus.OK);
	  }

	  @PutMapping(value = "/students/edit")
	  public Student updateStudent(@RequestBody Student student) {
	    return studentService.save(student);
	  }
}
	/*
	  @RequestMapping(value = "/products", method = RequestMethod.GET)
	  @ResponseBody
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<Product> getAllProducts() {
	    return productService.findAll();
	  }

	  @GetMapping(value = "/products/{id}")
	  @ResponseBody
	  public Product findProductById(@PathVariable Long id) {
	    return productService.findById(id);
	  }

	  @PostMapping(value = "/products/add")
	  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	    Product newProduct = productService.save(product);
	    return new ResponseEntity<Product>(newProduct , HttpStatus.CREATED);
	    //return new ResponseEntity<String>("Product Successfully Created!", HttpStatus.CREATED);
	  }

	  @DeleteMapping(value = "/products/delete/{id}")
	  @ResponseBody
	  public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
	    productService.delete(id);
	    return new ResponseEntity<String>("Product Deleted Successfully! Product ID: " + id,
	        HttpStatus.OK);
	  }

	  @PutMapping(value = "/products/update")
	  public Product updateProduct(@RequestBody Product product) {
	    return productService.save(product);
	  }
	*/
	
	
	


