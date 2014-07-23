package com.agrownet.solutions.emarket.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/initjourney")
public class SiteController {
	private static final Logger LOG = LoggerFactory.getLogger(SiteController.class);
	private static final String FIRST_MESSAGE="Hello AgrowNet, Wish you a great success!";
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getFirstMessage() {
		LOG.debug("First step towards long journey");
		return FIRST_MESSAGE;
	}	
}
