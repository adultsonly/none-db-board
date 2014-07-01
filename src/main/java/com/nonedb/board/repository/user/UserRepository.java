package com.nonedb.board.repository.user;

import com.nonedb.board.data.Data;
import com.nonedb.board.entitys.user.User;
import com.nonedb.board.exception.BoardException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 3:44
 * To change this template use File | Settings | File Templates.
 */
public class UserRepository {

    public User findOne(String uid) {
        Data data = Data.getInstance();
        List<User> users = data.getUsers();
        try {
            for (User user : users) {
                if (uid.equals(user.getUid())) {
                    return user;
                } else {
                    return null;
                }
            }
            throw new BoardException("회원정보가 없습니다.");
        } catch (Throwable t) {
            System.out.println("회원정보 참조 실패");
        }
        return null;
    }

    public List<User> findAll() {
        Data data = Data.getInstance();
        List<User> users = data.getUsers();
        return users;
    }

    public boolean insert(User user) {
        List<User> users = this.findAll();
        return users.add(user);
    }

    public boolean update(User user) {
        List<User> users = this.findAll();
        User result = users.set(Integer.parseInt(user.getId()), user);
        if (result != null) {
            return true;
        }
        return false;
    }

    public boolean delete(User user) {
        List<User> users = this.findAll();
        User result = users.remove(Integer.parseInt(user.getId()));
        if (result != null) {
            return true;
        }
        return false;
    }
}
