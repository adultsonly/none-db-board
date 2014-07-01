package com.nonedb.board.sort;

import com.nonedb.board.entitys.note.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 28
 * Time: 오후 10:00
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class SortTitleAscTest {
    @InjectMocks
    private SortTitleAsc sortTitleAsc = new SortTitleAsc();
    private static Note fisrstNote;
    private static Note secondNote;
    private static List<Note> notes;


    @Before
    public void setUp() throws Exception {
        fisrstNote = new Note();
        fisrstNote.setId("0");
        fisrstNote.setWriter("shiny");
        fisrstNote.setContent("test");
        fisrstNote.setTitle("abc");

        secondNote = new Note();
        secondNote.setId("1");
        secondNote.setWriter("shiny");
        secondNote.setContent("test");
        secondNote.setTitle("def");

        notes = new ArrayList<Note>();
        notes.add(fisrstNote);
        notes.add(secondNote);
    }

    @Test
    public void testHowSort() throws Exception {
        List<Note> result = sortTitleAsc.howSort(notes);
        assertThat(result.get(0).getTitle(), is("def"));
    }
}
