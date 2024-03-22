package org.example;

import java.util.List;

public class Authentication {
    public boolean checkLogin(String login, String pass, List<User> users){
        for (User user : users) {
            if(user.getLogin().equals(login)){
                if (md5(user.getPassword()).equals(pass)){
                    return true;
                }
            }
        }
        return false;
    }
    public String md5(String pass){
        //logika
        return pass;
    }
}
