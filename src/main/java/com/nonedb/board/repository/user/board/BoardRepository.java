package com.nonedb.board.repository.user.board;

import com.nonedb.board.data.Data;
import com.nonedb.board.entitys.board.Board;
import com.nonedb.board.entitys.note.Note;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 4:57
 * To change this template use File | Settings | File Templates.
 */
public class BoardRepository {
    private Data data;

    public List<Board> findAll() {
        data = Data.getInstance();
        return data.getBoards();
    }

    public Board findOne(String bId) {
        data = Data.getInstance();
        return data.getBoards().get(Integer.parseInt(bId));
    }

    public boolean deleteNote(String bId, String nId) {
        data = Data.getInstance();
        try {//체이닝하지말고.. 이부분을 순차적으로 나눠서 예외처리해야 더 확실 하겠지..
            data.getBoards().get(Integer.parseInt(bId)).getNotes().remove(Integer.parseInt(nId));
            return true;
        } catch (Exception e) {
            System.out.println("글 삭제 실패!");
        }
        return false;
    }

    public boolean updateNote(String bId, String nId, Note note) {
        data = Data.getInstance();
        try {
            data.getBoards().get(Integer.parseInt(bId)).getNotes().set(Integer.parseInt(nId), note);
            return true;
        } catch (Exception e) {
            System.out.println("글 수정 실패!");
        }
        return false;
    }

    public String insertNote(String bId, Note note) {
        data = Data.getInstance();
        try {
            data.getBoards().get(Integer.parseInt(bId)).getNotes().add(note);
            return note.getId();
        } catch (Exception e) {
            System.out.println("글 등록 실패!");
        }
        return null;
    }

    public boolean insertBoard(Board board) {
        data = Data.getInstance();
        try {
            return data.getBoards().add(board);
        } catch (Exception e) {
            System.out.println("게시판 등록 실패!");
        }
        return false;
    }
}
