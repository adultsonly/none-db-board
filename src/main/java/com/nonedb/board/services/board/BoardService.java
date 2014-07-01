package com.nonedb.board.services.board;

import com.nonedb.board.entitys.board.Board;
import com.nonedb.board.entitys.note.Note;
import com.nonedb.board.repository.user.board.BoardRepository;
import com.nonedb.board.sort.Sort;
import com.nonedb.board.sort.SortTitleAsc;
import com.nonedb.board.sort.SortTitleDesc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 3:53
 * To change this template use File | Settings | File Templates.
 */
public class BoardService {
    private BoardRepository boardRepository;
    private Sort sort;

    public BoardService() {
        boardRepository = new BoardRepository();
    }

    public List<Board> findAllService() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    public Board findService(String bId) {
        Board board = boardRepository.findOne(bId);
        return board;
    }

    public Note findNoteToBoard(String bId, String nId) {
        Board board = this.findService(bId);
        List<Note> notes = board.getNotes();
        Note note = notes.get(Integer.parseInt(nId));
        return note;
    }

    public boolean deleteNoteToBoard(String bId, String nId) {
        return boardRepository.deleteNote(bId, nId);
    }

    public boolean updateNoteToBoard(String bId, String nId, String title, String content) {
        Note note = this.findNoteToBoard(bId, nId);
        this.updateNoteService(note, title, content);
        return boardRepository.updateNote(bId, nId, note);
    }

    public Note updateNoteService(Note note, String title, String content) {
        note.setTitle(title);
        note.setContent(content);
        return note;
    }

    public String insertNoteToBoard(String bId, String uId, String title, String content) {
        Board board = this.findService(bId);
        String nId = String.valueOf(board.getNotes().size());
        Note note = this.insertNoteService(nId, uId, title, content);
        return boardRepository.insertNote(bId, note);
    }

    public Note insertNoteService(String nId, String uId, String title, String content) {
        Note note = new Note();
        note.setId(nId);
        note.setTitle(title);
        note.setContent(content);
        note.setWriter(uId);
        return note;
    }

    public List<Board> insertBoard(String uId, String title) {
        String bId = String.valueOf(this.findAllService().size());
        Board board = this.insertBoardService(uId, bId, title);
        if (boardRepository.insertBoard(board)) {
            return this.findAllService();
        }
        return null;
    }

    private Board insertBoardService(String uId, String bId, String title) {
        Board board = new Board();
        List<Note> notes = new ArrayList<Note>();
        board.setId(bId);
        board.setName(title);
        board.setRegId(uId);
        board.setNotes(notes);
        return board;
    }

    public List<Note> sortService(String bId, String howSort) {
        List<Note> notes = this.findAllService().get(Integer.parseInt(bId)).getNotes();
        if (howSort.equals("desc")) {
            this.sort = new SortTitleDesc();
            return sort.howSort(notes);
        } else {
            this.sort = new SortTitleAsc();
            return sort.howSort(notes);
        }
    }
}
