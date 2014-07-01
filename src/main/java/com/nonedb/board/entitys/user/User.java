package com.nonedb.board.entitys.user;

/**
 * Created with IntelliJ IDEA.
 * User: joowooni
 * Date: 14. 6. 26
 * Time: 오후 3:33
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String id;
    private String uId;
    private String pwd;
    private String name;

    public String getUid() {
        return uId;
    }

    public void setUid(String uId) {
        this.uId = uId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        boolean result = this.getUid().equals(user.getUid()) && this.getPwd().equals(user.getPwd()) && this.getName().equals(user.getName());
        return result;
    }
}
