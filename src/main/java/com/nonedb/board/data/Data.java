package com.nonedb.board.data;

import com.nonedb.board.entitys.board.Board;
import com.nonedb.board.entitys.note.Note;
import com.nonedb.board.entitys.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 3:37
 * To change this template use File | Settings | File Templates.
 */
public class Data {
    private List<User> users;
    private List<Board> boards;
    private static Data data;

    private Data() {
        this.userMigrate();
        this.boardMigration();
    }

    public static synchronized Data getInstance() {
        if (data == null) {
            data = new Data();
        }
        return data;
    }

    static {
        data = null;
    }

    public void userMigrate() {
        User user1 = new User();
        user1.setId("0");
        user1.setUid("shiny");
        user1.setPwd("1111");
        user1.setName("김지훈");

        List<User> users = new ArrayList<User>();
        users.add(user1);
        this.setUsers(users);
    }

    public void boardMigration() {
        boards = new ArrayList<Board>();
        Board board = new Board();
        board.setId("0");
        board.setName("공지사항");
        board.setRegId("shiny");
        boards.add(board);

        List<Note> noticeNotes = this.noteMigration();
        boards.get(0).setNotes(noticeNotes);
    }

    public List<Note> noteMigration() {
        Note note1 = new Note();
        note1.setId("0");
        note1.setWriter("shiny");
        note1.setTitle("안녕하세요.");
        note1.setTitle("구조를 잘 잡고 싶은데 어렵네요..");

        Note note2 = new Note();
        note2.setId("1");
        note2.setWriter("shiny");
        note2.setTitle("보드클래스밑에");
        note2.setTitle("노트를 두었더니.. 둘이 같이 항상 따라다녀야 하네요..");

        Note note3 = new Note();
        note3.setId("2");
        note3.setWriter("shiny");
        note3.setTitle("데이터베이스가");
        note3.setTitle("얼마나 좋은것인지 꺠달았습니다..");

        Note note4 = new Note();
        note4.setId("3");
        note4.setWriter("shiny");
        note4.setTitle("수업내용이 너무 좋아서");
        note4.setTitle("부족한 과제가 죄송할 따름입니다..");

        List<Note> notes = new ArrayList<Note>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);

        return notes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public static Data getData() {
        return data;
    }

    public static void setData(Data data) {
        Data.data = data;
    }
}
