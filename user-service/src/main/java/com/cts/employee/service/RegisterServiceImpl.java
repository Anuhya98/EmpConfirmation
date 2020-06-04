package com.cts.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.employee.entity.Register;
import com.cts.employee.model.RegisterDTO;
import com.cts.employee.repo.RegisterRepo;
@Service
public class RegisterServiceImpl implements RegisterService  {
	@Autowired
	RegisterRepo ur;
	@Autowired
	JavaMailSender jms;
	@Override
	public Register insert(Register rd) {
		ur.save(rd);
		try {
			SimpleMailMessage sm = new SimpleMailMessage();
			sm.setFrom("prudhvi.e1997@gmail.com");
			sm.setTo(rd.getEmail());
			sm.setSubject("verfication mail");
			sm.setText("Account created click on <a href='http://localhost:4200/activate?"+rd.getEmail()+"'>Click</a>");
			jms.send(sm);
			System.out.println("sending mail.....");
			}
		catch(Exception e) {e.printStackTrace();}
		return rd;
	}
	@Override
	public String activate(@RequestBody String email) {
		String str=email.substring(email.indexOf(":")+2,email.lastIndexOf("\""));
	System.out.println("emil ::"+str);
	Register us=	ur.findByEmail(str);
	System.out.println("uname :"+us.getEmail());
	us.setActive(true);
    us = ur.save(us);

       return "{\"status\":\"ok\"}";
	}
	
	@Override
	public List<Register> getAllUsers(){
		List<Register> entities = ur.findAll();
		List<Register> users = new ArrayList<Register>();
		for(Register entity: entities) {
			Register user = new Register();
			BeanUtils.copyProperties(entity, user);
			users.add(user);
		}
		return users;
	}
	
	@Override
	public void deleteById(int id) {
		ur.deleteById(id);
	}
	
	@Override
	public Register updateUser(Register users) {
		Register reg = new Register();
		BeanUtils.copyProperties(users, reg);
		BeanUtils.copyProperties(ur.save(reg), users);
		return users;
	}
	@Override
	public Register getUserById(int id) {
		Optional<Register> user =ur.findById(id);
		Register reg =new Register();
		BeanUtils.copyProperties(user.orElse(new Register()),reg);
		return reg;
	}
	@Override
	public RegisterDTO getUserByEmailAndPassword(String email, String password) {
		
		Register user=ur.findByEmailAndPassword(email,password);
		RegisterDTO registerDTO = new RegisterDTO();
		BeanUtils.copyProperties(user, registerDTO);
		return registerDTO;
	}
	
	

}
