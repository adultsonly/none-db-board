package com.nonedb.board.sort;

import com.nonedb.board.entitys.note.Note;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 5:53
 * To change this template use File | Settings | File Templates.
 */
public interface Sort {
    public List<Note> howSort(List<Note> notes);
}
