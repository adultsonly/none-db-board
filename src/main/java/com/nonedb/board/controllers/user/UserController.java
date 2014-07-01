package com.nonedb.board.controllers.user;

import com.nonedb.board.entitys.board.Board;
import com.nonedb.board.entitys.user.User;
import com.nonedb.board.services.board.BoardService;
import com.nonedb.board.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 3:44
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class UserController {

    private UserService userService;
    private BoardService boardService;

    public UserController() {
        userService = new UserService();
        boardService = new BoardService();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginControl() {
        ModelAndView mv = new ModelAndView("user/login/login");
        return mv;
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public ModelAndView joinControl() {
        ModelAndView mv = new ModelAndView("user/join/join");
        return mv;
    }

    @RequestMapping(value = "/loginProc", method = RequestMethod.POST)
    public ModelAndView loginProcControl(String uId, String pwd, HttpServletRequest request) {
        User user = userService.loginProcService(uId, pwd);
        ModelAndView mv;
        if (user == null) {
            mv = new ModelAndView("user/login/login");
            return mv;
        }
        HttpSession session = request.getSession();
        session.setAttribute("uId", user.getUid());
        session.setAttribute("name", user.getName());
        mv = new ModelAndView("board/boardList");
        List<Board> boards = boardService.findAllService();
        mv.addObject("boards", boards);
        return mv;
    }

    @RequestMapping(value = "/joinProc", method = RequestMethod.POST)
    public ModelAndView joinProcControl(String uId, String pwd, String uName) {
        boolean result = userService.joinProcService(uId, pwd, uName);
        ModelAndView mv;
        if (result == false) {
            mv = new ModelAndView("user/join/join");
            return mv;
        }
        mv = new ModelAndView("user/login/login");
        return mv;
    }
}
