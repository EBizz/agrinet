package com.agrownet.solutions.emarket.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {
	private static final Logger LOG = LoggerFactory.getLogger(SignInController.class);
	
	@RequestMapping(value = "signin")
	public String signin() {
		LOG.debug("User requested signin page");
        return "signin/signin";
    }
}
