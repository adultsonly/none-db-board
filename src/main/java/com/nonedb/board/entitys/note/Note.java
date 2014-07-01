package com.nonedb.board.entitys.note;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 3:34
 * To change this template use File | Settings | File Templates.
 */
public class Note {
    private String id;
    private String writer;
    private String title;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        Note note = (Note) obj;
        boolean result = this.getId().equals(note.getId()) && this.getContent().equals(note.getContent()) && this.getTitle().equals(note.getTitle()) && this.getWriter().equals(note.getWriter());
        return result;
    }
}
