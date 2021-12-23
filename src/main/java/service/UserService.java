package service;

import model.User;
import utils.UserCredentialsUtils;

public class UserService {

    public static User withRandomCredentials(){
        return UserCredentialsUtils.getRandomUser();
    }

    public static User withEmptyEmail(){
        return new User("", UserCredentialsUtils.getRandomPassword());
    }

    public static User withEmptyPassword(){
        return new User(UserCredentialsUtils.getRandomEmail(), "");
    }
}
