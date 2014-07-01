package com.nonedb.board.sort;

import com.nonedb.board.entitys.note.Note;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 5:54
 * To change this template use File | Settings | File Templates.
 */
public class SortTitleAsc implements Sort {
    @Override
    public List<Note> howSort(List<Note> notes) {
        for (int i = 0; i < notes.size(); i++) {
            for (int j = i + 1; j < notes.size(); j++) {
                if (notes.get(j).getTitle().compareTo(notes.get(i).getTitle()) > 0) {
                    Note swap = notes.get(i);
                    notes.set(i, notes.get(j));
                    notes.set(j, swap);
                }
            }
        }
        return notes;
    }
}
