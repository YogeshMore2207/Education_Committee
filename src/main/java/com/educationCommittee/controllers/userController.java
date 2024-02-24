package com.educationCommittee.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.educationCommittee.entityes.User;
import com.educationCommittee.otpService.GenerateOTP;
import com.educationCommittee.repos.UserRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Controller
@RequestMapping("/user")
public class userController {
	GenerateOTP diffrentValueforimageSaving = new GenerateOTP();
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/dashboard")
	public String UserHome(Principal principal,Model m) throws IOException {
		
		m.addAttribute("title","User Home - Education committee");
		
		String Username = principal.getName();
		User user = userRepo.getUserByUserName(Username);
		
	
		m.addAttribute("info",user);

		if(user.getName()==null) {
			return "user/Dashboard";
		}else if(user.getPaymentStatus().equals("NOT DONE")) {
			
			
//			System.out.println(user.getAadharPhoto());
//			System.out.println(user.getMarksheetPhoto());
//			//aadhar photo
//			File aadharphoto = new ClassPathResource("static/images/" + user.getAadharPhoto()).getFile();
//	        aadharphoto.delete();
//	        
//	        //marksheert photo
//	        File marksheetphoto = new ClassPathResource("static/images/" + user.getAadharPhoto()).getFile();
//	        marksheetphoto.delete();
			return "user/Dashboard";
		}else {
			m.addAttribute("info",user);
			return "user/Userinformation";
		}

		
		
		
	}
	


	
	
	@PostMapping("/do_process")
	public String SaveData(@ModelAttribute("info") User info,
	                       @RequestParam("aadharimg") MultipartFile aadharimg,
	                       @RequestParam("marksheetimg") MultipartFile marksheetimg,
	                       Principal p,Model m) throws IOException {

		
		m.addAttribute("title","Data Save Process - Education committee");
		
	    String rendomValue = diffrentValueforimageSaving.getOTP();
	    
	    String username = p.getName();
	    User user = this.userRepo.getUserByUserName(username);

	    // Save images
	    File savefile = new ClassPathResource("static/images").getFile();

	    // Generate unique filenames
	    String aadharFilename = rendomValue + "_" + aadharimg.getOriginalFilename();
	    String marksheetFilename = rendomValue + "_" + marksheetimg.getOriginalFilename();

	    Path aadharPath = Paths.get(savefile.getAbsolutePath() + File.separator + aadharFilename);
	    Files.copy(aadharimg.getInputStream(), aadharPath, StandardCopyOption.REPLACE_EXISTING);

	    Path marksheetPath = Paths.get(savefile.getAbsolutePath() + File.separator + marksheetFilename);
	    Files.copy(marksheetimg.getInputStream(), marksheetPath, StandardCopyOption.REPLACE_EXISTING);

	    user.setName(info.getName());
	    user.setAddress(info.getAddress());
	    user.setPhoneno(info.getPhoneno());
	    user.setParentNo(info.getParentNo());
	    user.setQualification(info.getQualification());
	    user.setAadharNo(info.getAadharNo());
	    user.setPaymentStatus("NOT DONE");

	    // Set the filenames with rendomValue
	    user.setAadharPhoto(aadharFilename);
	    user.setMarksheetPhoto(marksheetFilename);
	    
	    System.out.println(aadharFilename);
	    System.out.println(marksheetFilename);
	    
	    

	    this.userRepo.save(user);
	    
	    m.addAttribute("name",info.getName());

	    return "/user/pay";
	}



	
	
	//creating order for payment
	
	@PostMapping("/create_order")
	@ResponseBody
	public String CreateOrder(@RequestBody Map<String, Object> data) throws Exception {
		
		
		
		int amt = Integer.parseInt(data.get("amount").toString());
		
		var client = new RazorpayClient("rzp_test_8tKV787nlzcAEY","1wT41tFnf01s7ojqt3IhD1de");
		
		JSONObject ob = new JSONObject();
		ob.put("amount",amt*100);
		ob.put("currency", "INR");
		ob.put("receipt", "txn_235425");
		Order order = client.orders.create(ob);
	  //Order order = razorpayClient.orders.create(options);
		
		
		return order.toString();
	}
	
	//payment Status
	
	
	@PostMapping("/paymentStatus")
	@ResponseBody
	public void getStatus(Principal p) {
		
		String username = p.getName();		
		User user = this.userRepo.getUserByUserName(username);
		user.setPaymentStatus("Done");
		this.userRepo.save(user);
		
	}

}
