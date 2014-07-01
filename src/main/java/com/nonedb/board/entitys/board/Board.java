package com.nonedb.board.entitys.board;

import com.nonedb.board.entitys.note.Note;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 3:35
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private String id;
    private String name;
    private String regId;
    private List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    @Override
    public boolean equals(Object obj) {
        Board board = (Board) obj;
        boolean result = this.getId().equals(board.getId()) && this.getName().equals(board.getName()) && this.getRegId().equals(board.getRegId());
        return result;
    }
}
