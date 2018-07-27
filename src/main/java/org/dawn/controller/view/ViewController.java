package org.dawn.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 视图 Controller
 *
 * @author mgzu
 * @date 2018/7/10
 */
@Controller
public class ViewController {

    @RequestMapping("/websocket")
    public ModelAndView websocket() {
        return new ModelAndView("websocket.html");
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
