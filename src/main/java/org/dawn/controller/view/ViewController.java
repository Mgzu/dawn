package org.dawn.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	@RequestMapping("/webscoket")
	public ModelAndView webscoket() {
		return new ModelAndView("webscoket.html");
	}

	@RequestMapping("/table")
	public ModelAndView table() {
		return new ModelAndView("table.html");
	}

	@RequestMapping("/page")
	public ModelAndView page() {
		return new ModelAndView("page.html");
	}
}
