package org.dawn.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView defaultView() {
		return new ModelAndView("index.html");
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index.html");
	}
}
