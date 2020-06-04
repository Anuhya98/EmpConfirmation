package com.cts.employee.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employee.entity.Register;
import com.cts.employee.model.RegisterDTO;
import com.cts.employee.repo.RegisterRepo;
import com.cts.employee.service.RegisterService;
@CrossOrigin(origins="*")
@RestController
public class RegisterRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RegisterRepo ur;
	
	@Autowired
	JavaMailSender jms;
	
	@Autowired
	RegisterService registerservice;
	
	@Autowired
	EmployeeConfirmationServiceProxy empproxy;
	
	
	@GetMapping(value="/login")
  	public ResponseEntity<?> login(HttpServletRequest request)
  	{
		String authorization = request.getHeader("Authorization");
		logger.info("Login attempt with token -->{}",authorization);
		String email =null;
		String password = null;
		if(authorization !=null && authorization.startsWith("Basic")) {
			String base64Credentials = authorization.substring("Basic".length()).trim();
			byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			String credentials = new String(credDecoded,StandardCharsets.UTF_8);
			email = credentials.split(":")[0];
			password = credentials.split(":")[1];
		}
		try {
			RegisterDTO user =registerservice.getUserByEmailAndPassword(email,password);
			logger.info("user logged in using email -->{}",email);
			logger.info("user logged in using Password -->{}",password);
			return new ResponseEntity<RegisterDTO>(user,HttpStatus.OK);
		}catch(Exception e){
			
			System.out.println(e.getStackTrace());
			logger.info("unaothorized access Stack Trace-->{}",e.getStackTrace().toString());
			return new ResponseEntity<String>("No user found",HttpStatus.NOT_FOUND);
		}
  	
  	}
	
	@GetMapping("/registerall")
	public ResponseEntity<?>getallusers() {
		List<Register> list = registerservice.getAllUsers();
		if(list.size()>0)
		{
			return new ResponseEntity<List<Register>>(list , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No users found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/registerall/{id}")
	public ResponseEntity<Register> getById(@PathVariable int id){
		Register reg = registerservice.getUserById(id);
		return new ResponseEntity<Register>(reg,HttpStatus.OK);
	}
	
	@DeleteMapping("/registerall/{id}")
	public void delete(@PathVariable int id) {
		registerservice.deleteById(id);
	}
	
	@PutMapping("/registerall")
	public ResponseEntity<Register> update(@RequestBody Register users){
		registerservice.updateUser(users);
		return new ResponseEntity<Register>(users,HttpStatus.OK);
	}

	
	@RequestMapping(value = "/registerall",method = RequestMethod.POST)
	public ResponseEntity<Register> save(@RequestBody Register rd){
		registerservice.insert(rd);
		return new ResponseEntity<Register>(rd,HttpStatus.OK);
		
	}
	@RequestMapping(value="/activate",method= RequestMethod.PUT)
	public ResponseEntity<String> activate(@RequestBody String email){
		registerservice.activate(email);
		return new ResponseEntity<String>(email,HttpStatus.OK);
		
	}
	
	@GetMapping("/allemployees")
	public ResponseEntity<?> getAllEmployees(){
		logger.info("Get all emps invoked.");
		ResponseEntity<?> emps = empproxy.getAllEmployees();
		logger.info("Information --> {}",emps);
		return emps;
	}
	@GetMapping("/ribbon")
	public String ribbonTest() {
		String str = empproxy.ribbonTest();
	   return str ;
	}
	
}
