package com.tonghoangvu.r2sfrontendinternship.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController implements ErrorController {
	@RequestMapping("/error")
	public RedirectView error() {
		return new RedirectView("/error.html");
	}
}
