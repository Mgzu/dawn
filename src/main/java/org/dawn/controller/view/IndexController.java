package org.dawn.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 默认视图 Controller
 *
 * @author mgzu
 * @date 2018/7/10
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"", "index"})
    public ModelAndView defaultView() {
        return new ModelAndView("index.html");
    }
}
