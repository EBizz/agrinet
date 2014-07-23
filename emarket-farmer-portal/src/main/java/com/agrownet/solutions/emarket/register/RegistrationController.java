package com.agrownet.solutions.emarket.register;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agrownet.solutions.emarket.account.*;
import com.agrownet.solutions.emarket.support.web.*;

@Controller
public class RegistrationController {

    private static final String REGISTRATION_VIEW_NAME = "registration/register";

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserService userService;
	
	// Registration page
	@RequestMapping(value = "register")
	public String register(Model model) {
		model.addAttribute(new RegistrationForm());
        return REGISTRATION_VIEW_NAME;
	}
	
	//Post registration page, home page with post registration
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute RegistrationForm registrationForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return REGISTRATION_VIEW_NAME;
		}
		// Save the registration info, create member ship id send welcome message and email
		
		Account account = accountRepository.save(new Account(registrationForm.getEmail(), registrationForm.getPassword(), "ROLE_USER"));
		
		userService.signin(account);
        
		// see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, "registration.success");
		return "redirect:/";
	}
}
