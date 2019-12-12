package com.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capp.command.ContactCommand;
import com.capp.domain.Contact;
import com.capp.service.ContactService;

@Controller
public class ContactController {
   @Autowired
	private ContactService contactService;
	@RequestMapping(value="/user/contact_form")
	 public String contactForm(Model m){
		 m.addAttribute("command",new Contact());
		 return "contact_form";
	 }
	
	@RequestMapping(value="/user/save_contact")
	 public String saveContact(@ModelAttribute("command") Contact c, Model m , HttpSession session){
		  Integer contactId=(Integer) session.getAttribute("acontactId");
		  
		  if(contactId==null){
			  //save task
			  try{
					Integer userId = (Integer) session.getAttribute("userId");
					c.setUserId(userId);
					 m.addAttribute("command",c);
					 contactService.save(c);
					 return "redirect:clist?act=sv";
					}
					catch(Exception e){
						m.addAttribute("err", "Failed to save contact");
						return "contact_form";
					}
		  }
		  else{
			  try{
				    c.setContactId(contactId);
					 m.addAttribute("command",c);
					 contactService.update(c);
					 return "redirect:clist?act=ed";
					}
					catch(Exception e){
						e.printStackTrace();
						m.addAttribute("err", "Failed to Edit contact");
						return "contact_form";
					}
		  }
	 }
	@RequestMapping(value="/user/clist")
	 public String contactList(Model m, HttpSession session){
		Integer userId=(Integer) session.getAttribute("userId");
		m.addAttribute("userId");
		m.addAttribute("contactList", contactService.findUserContact(userId));
	    return "clist";
	 }
	
	@RequestMapping(value="/user/del_contact")
	 public String deleteContact(@RequestParam("cid") Integer contactId){
        contactService.delete(contactId);
		return "redirect:clist?act=del";
	 }
	
	@RequestMapping(value="/user/bulk_cdelete")
	 public String bulkDeleteContact(@RequestParam("cid") Integer[] contactIds){
		System.out.println("Selected Id is");
		if(contactIds.length==0) {
			return "redirect:clist?act=noSelect";
		}
       contactService.delete(contactIds);
		return "redirect:clist?act=del";
	 }
	
	@RequestMapping(value="/user/edit_contact")
	 public String prepareEditContact(Model m, HttpSession session,@RequestParam("cid") Integer contactId){
		session.setAttribute("acontactId",contactId);
        Contact c= contactService.findContactById(contactId);
        m.addAttribute("command",c);
		return "contact_form" ;
	 }
	
	@RequestMapping(value="/user/contact_search")
	 public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText){
		Integer userId=(Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.findUserContact(userId,freeText));
	    return "clist";
	 }
}
