package com.nonedb.board.controllers.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 28
 * Time: 오후 1:45
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainControl() {
        ModelAndView mv = new ModelAndView("start");
        return mv;
    }
}
