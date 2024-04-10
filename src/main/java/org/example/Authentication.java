package org.example;

import java.util.List;

public class Authentication {
        public static User login(String login, String hashedPass, List<User> users) throws UserNotFoundException, InvalidPasswordException{
        for (User user : users) {
            if(user.getLogin().equals(login)){
                if (hashedPass.equals(user.getPassword())){
                    return user;
                }
                else {
                    throw new InvalidPasswordException("Złe hasełko pani/e");
                }
            }
        }
        throw new UserNotFoundException("Nie znaleziono takiego usera");
    }
//    public String md5(String pass){
//        //logika
//        return pass;
//    }
}
