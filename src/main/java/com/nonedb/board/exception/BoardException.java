package com.nonedb.board.exception;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 5:38
 * To change this template use File | Settings | File Templates.
 */
public class BoardException extends Exception {
    private static final long serialVersionUID = 688158917120330523L;

    public BoardException() {
        super();
    }

    public BoardException(String message) {
        super(message);
    }
}