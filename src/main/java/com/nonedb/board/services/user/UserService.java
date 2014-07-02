package com.nonedb.board.services.user;

import com.nonedb.board.entitys.user.User;
import com.nonedb.board.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 3:53
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public User loginProcService(String uId, String pwd) {
        User user = userRepository.findOne(uId);
        if (user.getPwd().equals(pwd)) {
            return user;
        }
        return null;
    }

    public boolean joinProcService(String uId, String pwd, String uName) {
        return this.insertUserService(uId, pwd, uName);
    }

    public boolean insertUserService(String uId, String pwd, String uName) {
        String id = "0";
        List<User> reslut = this.findAllService();
        if (reslut != null) {
            id = String.valueOf(this.findAllService().size());
        }
        User user = this.insertUser(id, uId, pwd, uName);
        return userRepository.insert(user);
    }

    private User insertUser(String id, String uId, String pwd, String uName) {
        User user = new User();
        user.setId(id);
        user.setuId(uId);
        user.setPwd(pwd);
        user.setName(uName);
        return user;
    }

    public List<User> findAllService() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
