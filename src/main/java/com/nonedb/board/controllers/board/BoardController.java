package com.nonedb.board.controllers.board;

import com.nonedb.board.entitys.board.Board;
import com.nonedb.board.entitys.note.Note;
import com.nonedb.board.services.board.BoardService;
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
public class BoardController {
    private BoardService boardService;

    public BoardController() {
        boardService = new BoardService();
    }

    @RequestMapping(value = "/boardReg", method = RequestMethod.GET)
    public ModelAndView boardRegControl() {
        ModelAndView mv = new ModelAndView("board/boardReg");
        return mv;
    }

    @RequestMapping(value = "/noteList", method = RequestMethod.GET)
    public ModelAndView noteListControl(String bId) {
        ModelAndView mv = new ModelAndView("note/noteList");
        Board board = boardService.findService(bId);
        List<Note> notes = board.getNotes();
        mv.addObject("bId", bId);
        mv.addObject("notes", notes);
        return mv;
    }

    @RequestMapping(value = "/noteDetail", method = RequestMethod.GET)
    public ModelAndView noteDetailControl(String nId, String bId) {
        ModelAndView mv = new ModelAndView("note/noteDetail");
        Note note = boardService.findNoteToBoard(bId, nId);
        mv.addObject("bId", bId);
        mv.addObject("note", note);
        return mv;
    }

    //노트를 위해서 계속 이렇게 보드에 붙여 다녀야하는건가..
    @RequestMapping(value = "/noteEdit", method = RequestMethod.GET)
    public ModelAndView noteEditControl(String nId, String bId) {
        ModelAndView mv = new ModelAndView("note/noteEdit");
        Note note = boardService.findNoteToBoard(bId, nId);
        mv.addObject("bId", bId);
        mv.addObject("note", note);
        return mv;
    }

    @RequestMapping(value = "/noteReg", method = RequestMethod.GET)
    public ModelAndView noteRegControl(String bId) {
        ModelAndView mv = new ModelAndView("note/noteReg");
        mv.addObject("bId", bId);
        return mv;
    }

    @RequestMapping(value = "/noteDelProc", method = RequestMethod.GET)
    public ModelAndView noteDeleteProc(String nId, String bId) {
        ModelAndView mv;
        if (boardService.deleteNoteToBoard(bId, nId)) {
            Board board = boardService.findService(bId);
            List<Note> notes = board.getNotes();
            mv = new ModelAndView("note/noteList");
            mv.addObject("bId", bId);
            mv.addObject("notes", notes);
            return mv;
        } else {
            mv = new ModelAndView("error/error");
            return mv;
        }
    }

    @RequestMapping(value = "/noteEditProc", method = RequestMethod.POST)
    public ModelAndView noteEditProc(String nId, String bId, String title, String content) {
        ModelAndView mv;
        if (boardService.updateNoteToBoard(bId, nId, title, content)) {
            mv = new ModelAndView("note/noteDetail");
            Note note = boardService.findNoteToBoard(bId, nId);
            mv.addObject("bId", bId);
            mv.addObject("note", note);
            return mv;
        } else {
            mv = new ModelAndView("error/error");
            return mv;
        }
    }

    @RequestMapping(value = "/noteRegProc", method = RequestMethod.POST)
    public ModelAndView noteRegProc(String bId, String title, String content, HttpServletRequest request) {
        ModelAndView mv;
        HttpSession session = request.getSession();
        String uId = (String) session.getAttribute("uId");
        String nId = boardService.insertNoteToBoard(bId, uId, title, content);
        if (nId != null) {
            Note note = boardService.findNoteToBoard(bId, nId);
            mv = new ModelAndView("note/noteDetail");
            mv.addObject("bId", bId);
            mv.addObject("note", note);
            return mv;
        } else {
            mv = new ModelAndView("error/error");
            return mv;
        }
    }

    @RequestMapping(value = "/boardRegProc", method = RequestMethod.POST)
    public ModelAndView noteRegProc(String title, HttpServletRequest request) {
        ModelAndView mv;
        HttpSession session = request.getSession();
        String uId = (String) session.getAttribute("uId");
        List<Board> boards = boardService.insertBoard(uId, title);
        if (boards != null) {
            mv = new ModelAndView("board/boardList");
            mv.addObject("boards", boards);
            return mv;
        } else {
            mv = new ModelAndView("error/error");
            return mv;
        }
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ModelAndView sortControl(String bId, String howSort) {
        ModelAndView mv = new ModelAndView("note/noteList");
        List<Note> notes = boardService.sortService(bId, howSort);
        mv.addObject("bId", bId);
        mv.addObject("notes", notes);
        return mv;
    }
}
