package com.educationCommittee.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.educationCommittee.entityes.User;
import com.educationCommittee.repos.UserRepo;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	
	@Autowired
	UserRepo userRepo;
	
	
	@GetMapping("/Adminhome")
	public String AdminPage(Model m) {
		m.addAttribute("title","Admin Home - Education committee");
		
		List<User> allusers = this.userRepo.findAll();
		
		m.addAttribute("allusers", allusers);
			

		
		return "admin/AdminPage";
	}
	
	
	
	//show single user
	@GetMapping("/singleUser/{id}")
	public String single_user(@PathVariable("id") int id,Model m) {
		
		m.addAttribute("title","User Detail - Education committee");
		
		User user = this.userRepo.getUserByUserId(id);
		
		m.addAttribute("info",user);
		
		return "admin/Annausment";
	}	

	
	
//	//delete user
//	
		@GetMapping("/delete/{id}")
		public String DeleteUser(@PathVariable("id") int id,Model m) throws IOException {
			m.addAttribute("title","Delete User - Education committee");
			
			User user = this.userRepo.getUserByUserId(id);
			
			this.userRepo.delete(user);
			
			
			//delete photo
			
			try {
				//aadhar card photo 
				File aadharphoto = new ClassPathResource("static/images/" + user.getAadharPhoto()).getFile();
		        aadharphoto.delete();
		        
		        //marksheert photo
		        File marksheetphoto = new ClassPathResource("static/images/" + user.getMarksheetPhoto()).getFile();
		        marksheetphoto.delete();
			} catch (Exception e) {
				// TODO: handle exception
			}

			
			return "redirect:/admin/Adminhome";
		}	
	
}
