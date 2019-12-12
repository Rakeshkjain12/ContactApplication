 package com.capp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capp.command.LoginCommand;
import com.capp.command.UserCommand;
import com.capp.domain.User;
import com.capp.exception.UserBlockException;

import com.capp.service.UserService;
import com.capp.service.mailService;
import com.capp.util.RandomOTPUtil;
import com.capp.util.otpValidation;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	mailService mservice;

	@RequestMapping(value = { "/index" })
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index";
	}

	@RequestMapping(value = "/login")
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		try {
			User loggedInUser = userService.login(cmd.getUserName(), cmd.getPassword());
			UserCommand userc = new UserCommand();
			userc.setUser(loggedInUser);
			if (loggedInUser == null) {
				m.addAttribute("err", "Login Failed. Enter valid credentials");
				return "index";
			} else {
				if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					addUserInSession(loggedInUser, session);
					return "redirect:/admin/dashboard";
				} else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
					addUserInSession(loggedInUser, session);
					return "redirect:/user/dashboard";
				} else {
					m.addAttribute("err", "Invalid User Role");
					return "index";
				}
			}

		} catch (UserBlockException e) {
			m.addAttribute("err", e.getMessage());
			return "index";
		}
	}

	@RequestMapping(value = "/user/dashboard")
	public String userdashboard(Model m, HttpSession session) {
		Integer uid=(Integer) session.getAttribute("userId");
		User u =userService.getUser(uid);
		m.addAttribute("u", u);
		return "dashboard_user";
	}

	@RequestMapping(value = "/admin/dashboard")
	public String admindashboard(Model m, HttpSession session) {
		Integer uid=(Integer) session.getAttribute("userId");
		User u =userService.getUser(uid);
		m.addAttribute("u", u);
		return "dashboard_admin";
	}

	@RequestMapping(value = {"/admin/editUser","/user/editUser"})
	public String userEdit(Model m, HttpSession session) {

		Integer uid = (Integer) session.getAttribute("userId");
		session.setAttribute("euserId", uid);
		User u = userService.getUser(uid);
		UserCommand cmd = new UserCommand();
		cmd.setUser(u);
		m.addAttribute("command", cmd);
		return "reg_form";
	}
	
	@RequestMapping(value = "/user/deleteUser")
	public String deleteEdit(Model m, HttpSession session) {

		Integer uid = (Integer) session.getAttribute("userId");
		Integer urole= (Integer) session.getAttribute("role");
		userService.deleteUser(uid);
		return "redirect:/logout";
	}

	@RequestMapping(value = "/check_user_avail")
	@ResponseBody
	public String checkUserAvail(@RequestParam String loginName) {
		if (userService.isUserAvailable(loginName)) {
			return "username already available , please choose another.";
		} else {
			return "Available";
		}

	}

	@RequestMapping(value = "/admin/getuserList")
	public String getUserList(Model m) {
		Object Role = userService.ROLE_USER;
		List<User> list = userService.getAllUser("role", Role);

		m.addAttribute("userList", list);
		return "ulist";
	}

	@RequestMapping(value = "/reg_form")
	public String registrationForm(Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command", cmd);
		return "reg_form";
	}

	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m, HttpSession session) {
		Integer uid = (Integer) session.getAttribute("euserId");
		if (uid == null) {
			//Save User
			try {
				User user = cmd.getUser();
				user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
				user.setRole(UserService.ROLE_USER);
				userService.register(user);
				return "redirect:/index?act=reg";

			} catch (DuplicateKeyException e) {
				e.printStackTrace();
				m.addAttribute("err", "Username already registered, please select another Username");
				return "reg_form";
			}
		} else {
			//Update User
			try {
				
				
				
				User u=cmd.getUser();
				Integer urole=(Integer) session.getAttribute("role");
				u.setRole(urole);
				u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
	            u.setUserId(uid);
	            
	       
				
				int res=userService.updateUser(u);
				if(res==1) {
                    if(urole==1) {
                    	return "redirect:/admin/dashboard?act=es";
                    }else {
                    	return "redirect:/user/dashboard?act=es";
                    }
					
				}else {

                    if(urole==1) {
                    	return "redirect:/admin/dashboard?act=ss";
                    }else {
                    	return "redirect:/user/dashboard?act=nmp";
                    }
					
				}
			  
			
			} catch (DuplicateKeyException e) {
				e.printStackTrace();
				m.addAttribute("err", "Username already registered, please select another Username");
				return "reg_form";
			}

		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index?act=lo";
	}

	@RequestMapping(value = "/admin/change_status")
	@ResponseBody
	public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus) {
		try {
			userService.changeLoginStatus(userId, loginStatus);
			System.out.println(userId + " " + loginStatus);
			return "SUCCESS: Status Changed";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR: Unable to change Status";

		}
	}
	/*-------------------- adding value in session ------------------------*/
	

	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}

	/*------------------------------------------------Forgot Password Functionality----------------------------------------------------------------*/

	@Autowired
	mailService mService;

	@RequestMapping(value = "/checkEmailId")
	public String checkEmail(@RequestParam String email, Model m) {
		try {
			if (userService.isEmailAvailable(email)) {
				String otp = RandomOTPUtil.randomOTP();
				otpValidation.SetOtp(email, otp);
				mService.sendMail("rakeshproject123@gmail.com", email, "Password ResetLink",
						"One Time Password is " + otp + "");

				return "redirect:/resetPassword?act=snt";
			} else {
				m.addAttribute("err", "Email Id is Not Registered ! ");
				return "findpass";
			}
		} catch (Exception e) {
			e.printStackTrace();
			String str = e.getMessage();
			m.addAttribute("err", "Sorry..! Mail Not Sent");

			return "findpass";
		}
	}
	
	
	@RequestMapping(value = "/resetPassword")
	public String passwordRest() {
		return "resetPass";
	}
	
	@RequestMapping(value = "/genePassword")
	public String generateRest(@RequestParam String otp,@RequestParam String password,@RequestParam String email) {
	
		if(otpValidation.isCorrectOTP(email, otp)) {
			userService.resetPass(email, password);
			return "redirect:/resetPassword?act=suc";
		}else {
			System.out.println("failure part is runing");
		return "redirect:/resetPassword?act=fil";
	}
	}
}
